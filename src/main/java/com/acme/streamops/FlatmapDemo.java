package com.acme.streamops;

import com.acme.common.Customer;
import com.acme.common.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

public class FlatmapDemo {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAll();

		List<String> currencies = customers.stream().map(Customer::getCurrencies).flatMap(List::stream)
				.collect(Collectors.toList());

		System.out.println(currencies);

		System.out.println("Sorted:");
		currencies.stream().sorted().forEach(System.out::println);

		long count = currencies.stream().distinct().count();
		System.out.println("Count of distinct: " + count);

	}
}
