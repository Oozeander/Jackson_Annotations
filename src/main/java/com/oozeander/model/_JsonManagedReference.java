package com.oozeander.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class _JsonManagedReference {
	@NonNull
	private Long id;
	@NonNull
	private String firstname, lastname;
	@JsonManagedReference
	private List<_JsonBackReference> jsonBackReferences;
}