package com.oozeander.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class _JsonUnwrapped {
	private Long id;
	@JsonUnwrapped
	private Identity identity;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Identity {
		private String firstname, lastname;
	}
}