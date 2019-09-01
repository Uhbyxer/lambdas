package com.acme.streamops.terminal;

import com.acme.common.Customer;
import com.acme.common.CustomerService;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MinMaxAverageStatsByDemo {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAll();

		Optional<Customer> minByAge = customers.stream()
				.collect(Collectors.minBy(Comparator.comparing(Customer::getAge)));
		Optional<Customer> maxByAge = customers.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Customer::getAge)));


		minByAge.ifPresent(customer -> {
			System.out.println("With min age: " + customer);
		});

		maxByAge.ifPresent(customer -> {
			System.out.println("With max age: " + customer);
		});

		IntSummaryStatistics stats = customers.stream().collect(Collectors.summarizingInt(Customer::getAge));
		System.out.println("Summary stat:" + stats);

		Double average = customers.stream().collect(Collectors.averagingInt(Customer::getAge));
		System.out.println("Average age: " + average);

		Integer sum = customers.stream().collect(Collectors.summingInt(Customer::getAge));
		System.out.println("Sum: " + sum);
	}
}
