package com.acme.common;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
	public List<Customer> getAll() {
		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(new Customer("John", "Doe", 17, "Mr"));
		customers.add(new Customer("Joanne", "Doe", 28, "Ms"));
		customers.add(new Customer("Freddy", "Smith", 30, "Dr"));

		return customers;
	}
}
