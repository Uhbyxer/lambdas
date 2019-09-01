package com.acme.streamops.terminal;

import com.acme.common.Customer;
import com.acme.common.CustomerService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupingByMaxMinDemo {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAll();

		Map<String, Optional<Customer>> maxAgeInSalutation = customers.stream().collect(Collectors
				.groupingBy(Customer::getSalutation, Collectors.maxBy(Comparator.comparing(Customer::getAge))));
		maxAgeInSalutation
				.forEach((s, customer) -> System.out.println("Salutation: " + s + ", Max age: " + customer.get()));

		Map<String, Double> groupByAverage = customers.stream()
				.collect(Collectors.groupingBy(Customer::getSalutation, Collectors.averagingInt(Customer::getAge)));
		System.out.println("Group by average age:");
		System.out.println(groupByAverage);

		//Collectors.collectingAndThen
		Map<String, String> whoIsAverageInGroup = customers.stream().collect(Collectors.groupingBy(Customer::getSalutation,
				Collectors.collectingAndThen(Collectors.averagingInt(Customer::getAge),
						aDouble -> aDouble >= 18 ? "adult" : "child")));
		System.out.println("Average in each group of salutations:");
		System.out.println(whoIsAverageInGroup);
	}
}
