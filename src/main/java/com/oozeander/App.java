package com.oozeander;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.oozeander.model._JsonAnyGetterSetter;
import com.oozeander.model._JsonBackReference;
import com.oozeander.model._JsonFormat;
import com.oozeander.model._JsonIdentityInfo;
import com.oozeander.model._JsonIgnorePropertiesOrder;
import com.oozeander.model._JsonInclude;
import com.oozeander.model._JsonManagedReference;
import com.oozeander.model._JsonProperty;
import com.oozeander.model._JsonRawValue;
import com.oozeander.model._JsonRootName;
import com.oozeander.model._JsonUnwrapped;
import com.oozeander.model._JsonValue;
import com.oozeander.model._JsonView;
import com.oozeander.model._UserView;

public class App {
	private final static ObjectMapper mapper = new ObjectMapper();
	private final static Logger LOGGER = LogManager.getLogger(App.class);

	public static void main(String[] args) throws IOException {
		configureObjectMapper(mapper);

		// JsonProperty => Associates different name to Json String
		_JsonProperty jsonProperty = new _JsonProperty(1L, "Just a test");
		String jsonPropertyString = mapper.writeValueAsString(jsonProperty);
		LOGGER.info(jsonPropertyString);
		LOGGER.info(mapper.readValue(jsonPropertyString, _JsonProperty.class));

		// JsonAnyGetter / JsonAnySetter => Unwrap Map (enabled = true OR none)
		_JsonAnyGetterSetter jsonAnyGetterSetter = new _JsonAnyGetterSetter(
				Map.of("Java", 15, "Spring", 14, "Hibernate", 15, "Angular", 11));
		String jsonAnyGetterSetterString = mapper.writeValueAsString(jsonAnyGetterSetter);
		LOGGER.info(jsonAnyGetterSetterString);
		LOGGER.info(mapper.readValue(jsonAnyGetterSetterString, _JsonAnyGetterSetter.class));

		// JsonValue => Prints One AND Unique attribute on Json String
		_JsonValue jsonValue = new _JsonValue(1L, "KETROUCI Billel");
		String jsonValueString = mapper.writeValueAsString(jsonValue);
		LOGGER.info(jsonValueString);
		LOGGER.info(mapper.readValue(jsonValueString, _JsonValue.class));

		// JsonRootName => Associates RootValue for Json String
		_JsonRootName jsonRootName = new _JsonRootName(1L, "KETROUCI Billel");
		String jsonRootNameString = mapper.writeValueAsString(jsonRootName);
		LOGGER.info(jsonRootNameString);
		LOGGER.info(mapper.readValue(jsonRootNameString, _JsonRootName.class));

		// JsonRawValue => Insert enescapable content (JSON, XML, Yaml, ...)
		_JsonRawValue jsonRawValue = new _JsonRawValue(1L, "{\"id\" : 1, \"name\" : \"KETROUCI Billel\"}");
		LOGGER.info(mapper.writeValueAsString(jsonRawValue)); // For Serialization Only

		// JsonPropertyOrder / JsonIgnoreProperties / JsonIgnore
		_JsonIgnorePropertiesOrder jsonIgnorePropertiesOrder = new _JsonIgnorePropertiesOrder(1L, "Billel", "KETROUCI",
				24);
		LOGGER.info(mapper.writeValueAsString(jsonIgnorePropertiesOrder));

		// JsonInclude => Include NON-NULL / NON-EMPTY / ... values in Json
		_JsonInclude jsonInclude = new _JsonInclude(null, "Billel", "", null);
		LOGGER.info(mapper.writeValueAsString(jsonInclude));

		// JsonFormat => convert Date to String with wanted pattern
		_JsonFormat jsonFormat = new _JsonFormat(1L, "KETROUCI Billel", new Date(),
				LocalDateTime.of(LocalDate.of(1996, 9, 9), LocalTime.of(4, 53)));
		String jsonFormatString = mapper.writeValueAsString(jsonFormat);
		LOGGER.info(jsonFormatString);
		LOGGER.info(mapper.readValue(jsonFormatString, _JsonFormat.class));

		// JsonUnwrapped => Unwrap complex POJOs
		_JsonUnwrapped jsonUnwrapped = new _JsonUnwrapped(1L, new _JsonUnwrapped.Identity("Billel", "KETROUCI"));
		String jsonUnwrappedString = mapper.writeValueAsString(jsonUnwrapped);
		LOGGER.info(jsonUnwrappedString);
		LOGGER.info(mapper.readValue(jsonUnwrappedString, _JsonUnwrapped.class));

		// JsonView => Serialize/Deserialize with multiple criteria/permissions
		_UserView userView = new _UserView(1L, "Billel", "KETROUCI",
				LocalDateTime.of(LocalDate.of(1996, 9, 9), LocalTime.of(4, 53)), BigDecimal.valueOf(1735.59),
				"Ingénieur", false);
		String userViewPublic = mapper.writerWithView(_JsonView.Public.class).writeValueAsString(userView),
				userViewEmployee = mapper.writerWithView(_JsonView.Employee.class).writeValueAsString(userView),
				userViewHR = mapper.writerWithView(_JsonView.HR.class).writeValueAsString(userView),
				userViewAdmin = mapper.writerWithView(_JsonView.Admin.class).writeValueAsString(userView);

		LOGGER.info("Public view Serialized : " + userViewPublic);
		LOGGER.info("Employee view Serialized : " + userViewEmployee);
		LOGGER.info("HR view Serialized : " + userViewHR);
		LOGGER.info("Admin view Serialized : " + userViewAdmin);

		_UserView userViewPublicPOJO = mapper.readerWithView(_JsonView.Public.class).forType(_UserView.class)
				.readValue(userViewPublic),
				userViewEmployeePOJO = mapper.readerWithView(_JsonView.Employee.class).forType(_UserView.class)
						.readValue(userViewEmployee),
				userViewHRPOJO = mapper.readerWithView(_JsonView.HR.class).forType(_UserView.class)
						.readValue(userViewHR),
				userViewAdminPOJO = mapper.readerWithView(_JsonView.Admin.class).forType(_UserView.class)
						.readValue(userViewAdmin);
		LOGGER.info("Public view Deserialized : " + userViewPublicPOJO);
		LOGGER.info("Employee view Deserialized : " + userViewEmployeePOJO);
		LOGGER.info("HR view Deserialized : " + userViewHRPOJO);
		LOGGER.info("Admin view Deserialized : " + userViewAdminPOJO);

		// JsonManagedReference / JsonBackReference => OneToMany / OneToOne
		_JsonManagedReference jsonManagedReference = new _JsonManagedReference(1L, "Billel", "KETROUCI");
		_JsonBackReference jsonBackRefernce1 = new _JsonBackReference(1L, "ASUS Laptop", jsonManagedReference),
				jsonBackRefernce2 = new _JsonBackReference(2L, "Sony Smartphone", jsonManagedReference),
				jsonBackRefernce3 = new _JsonBackReference(3L, "Japanese Katana", jsonManagedReference);
		jsonManagedReference
				.setJsonBackReferences(Arrays.asList(jsonBackRefernce1, jsonBackRefernce2, jsonBackRefernce3));

		String jsonManagedReferenceString = mapper.writeValueAsString(jsonManagedReference),
				jsonBackReference1String = mapper.writeValueAsString(jsonBackRefernce1);
		LOGGER.info(jsonManagedReferenceString);
		LOGGER.info(jsonBackReference1String);

		LOGGER.info(mapper.readValue(jsonManagedReferenceString, _JsonManagedReference.class));
		LOGGER.info(mapper.readValue(jsonBackReference1String, _JsonBackReference.class));

		// JsonIdentityInfo => OneToMany / OneToOne
		_JsonIdentityInfo.User user = new _JsonIdentityInfo.User("Billel", "KETROUCI");
		_JsonIdentityInfo.Item item1 = new _JsonIdentityInfo.Item("ASUS Laptop", user),
				item2 = new _JsonIdentityInfo.Item("Sony Smartphone", user),
				item3 = new _JsonIdentityInfo.Item("Japanese Katana", user);
		user.setItems(Arrays.asList(item1, item2, item3));

		String userString = mapper.writeValueAsString(user), item1String = mapper.writeValueAsString(item1);

		LOGGER.info(userString);
		LOGGER.info(item1String);

		LOGGER.info(mapper.readValue(userString, _JsonIdentityInfo.User.class));
		LOGGER.info(mapper.readValue(item1String, _JsonIdentityInfo.Item.class));
	}

	private static void configureObjectMapper(ObjectMapper mapper) {
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
	}
}