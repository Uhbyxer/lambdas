package com.acme.streamops;

import com.acme.common.Customer;
import com.acme.common.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

public class PeekDemo {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAll();

		//peek
		System.out.println("Peek demo");
		List<String> result = customers.stream().peek(customer -> {
			System.out.println("Before: " + customer);
		}).filter(customer -> customer.getAge() >= 18).peek(customer -> {
			System.out.println("After filter: " + customer);
		}).map(Customer::getName).peek(s -> System.out.println("After map: " + s)).collect(Collectors.toList());

		System.out.println("Result");
		System.out.println(result);
	}
}
