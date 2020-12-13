package com.oozeander.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "id" })
@JsonPropertyOrder({ "lastname", "firstname", "age" })
public class _JsonIgnorePropertiesOrder {
	private Long id;
	private String firstname;
	private String lastname;
	private Integer age;
}