package com.oozeander.model;

import com.fasterxml.jackson.annotation.JsonRawValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class _JsonRawValue {
	private Long id;
	@JsonRawValue
	private String content;
}