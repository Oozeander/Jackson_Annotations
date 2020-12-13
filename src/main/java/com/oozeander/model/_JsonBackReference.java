package com.oozeander.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class _JsonBackReference {
	private Long id;
	private String item;
	@ToString.Exclude
	@JsonBackReference
	private _JsonManagedReference jsonManagedReference;
}