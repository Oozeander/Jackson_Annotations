package com.oozeander.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class _JsonIdentityInfo {
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@RequiredArgsConstructor
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "firstname")
	public static class User {
		@NonNull
		private String firstname, lastname;
		private List<Item> items;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "itemName")
	public static class Item {
		private String itemName;
		@ToString.Exclude
		private User user;
	}
}