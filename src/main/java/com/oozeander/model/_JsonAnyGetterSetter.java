package com.oozeander.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class _JsonAnyGetterSetter {
	@JsonAnySetter(enabled = true)
	private Map<String, Integer> skills = new HashMap<>();

	@JsonAnyGetter(enabled = true)
	public Map<String, Integer> getSkills() {
		return this.skills;
	}
}