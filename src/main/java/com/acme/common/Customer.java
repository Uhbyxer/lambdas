package com.acme.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private String name;
	private String surname;
	private int age;
	private String salutation;

	private List<String> currencies;
}
