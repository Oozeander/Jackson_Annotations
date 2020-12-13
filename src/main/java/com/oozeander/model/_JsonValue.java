package com.oozeander.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class _JsonValue {
	private Long id;
	@JsonValue
	@JsonProperty("name")
	private String fullName;

	public _JsonValue(String fullName) {
		this.fullName = fullName;
	}
}