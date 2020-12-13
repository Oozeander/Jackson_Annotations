package com.oozeander.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.oozeander.adapter.LocalDateTimeDeserializer;
import com.oozeander.adapter.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class _UserView {
	@JsonView(_JsonView.Admin.class)
	private Long id;
	@JsonView(_JsonView.Public.class)
	private String firstname, lastname;
	@JsonView(_JsonView.Employee.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime birthDate;
	@JsonView(_JsonView.Employee.class)
	private BigDecimal salary;
	@JsonView(_JsonView.Public.class)
	private String profession;
	@JsonView(_JsonView.Admin.class)
	private boolean happyAtWork;
}