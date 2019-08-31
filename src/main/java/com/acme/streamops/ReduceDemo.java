package com.acme.streamops;

import com.acme.common.Customer;
import com.acme.common.CustomerService;

import java.util.List;
import java.util.Optional;

public class ReduceDemo {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAll();

		Integer sumAge = customers.stream().map(Customer::getAge).reduce(0, (x, y) -> x + y);
		System.out.println("Sum of Age: " + sumAge);

		Optional<Integer> maxAge = customers.stream().map(Customer::getAge).reduce(Integer::max);
		maxAge.ifPresent(max -> System.out.println("Max age: " + max));

	}
}
