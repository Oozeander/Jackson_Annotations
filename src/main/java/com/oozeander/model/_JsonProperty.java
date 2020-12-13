package com.oozeander.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class _JsonProperty {
	@JsonProperty("id")
	private Long myId;
	@JsonProperty("content")
	private String myContent;
}