package com.acme.streamops.terminal;

import com.acme.common.Customer;
import com.acme.common.CustomerService;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JoiningCountingDemo {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAll();

		System.out.println(customers.stream().map(Customer::getName).collect(Collectors.joining()));
		System.out.println(customers.stream()
				.map(Customer::getName).collect(Collectors.joining(", ")));
		System.out.println(customers.stream()
				.map(Customer::getName).collect(Collectors.joining(", ", "{", "}")));

		System.out.println(customers.stream().map(Customer::getName).collect(Collectors.counting()));


		System.out.println(customers.stream().collect(Collectors.mapping(Customer::getSurname, Collectors.toList())));
		System.out.println(customers.stream().map(Customer::getSurname).distinct()
				.collect(Collectors.toMap(Function.identity(), s -> s.length())));


	}
}
