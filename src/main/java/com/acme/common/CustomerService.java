package com.acme.common;

import java.util.*;

import static java.util.Arrays.asList;

public class CustomerService {
	public List<Customer> getAll() {
		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(new Customer("John", "Doe", 17, "Mr", asList("USD", "UAH")));
		customers.add(new Customer("Joanne", "Doe", 28, "Ms", asList("USD", "EUR")));
		customers.add(new Customer("Freddy", "Smith", 30, "Dr", asList("EUR")));
		customers.add(new Customer("Alfred", "Smith", 30, "Dr", asList("EUR", "USD")));
		customers.add(new Customer("Alfred", "Smith", 30, "Dr", asList("EUR")));
		customers.add(new Customer("Alfred", "Smith", 30, "Dr", asList("EUR", "UAH")));

		return customers;
	}
}
