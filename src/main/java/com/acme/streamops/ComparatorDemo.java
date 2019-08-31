package com.acme.streamops;

import com.acme.common.Customer;
import com.acme.common.CustomerService;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ComparatorDemo {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAll();

		System.out.println("By age desc");
		customers.stream().sorted(Comparator.comparing(Customer::getAge).reversed().thenComparing(Customer::getName))
				.forEach(System.out::println);

		System.out.println("Sort names");
		customers.stream().map(Customer::getName).sorted(String::compareToIgnoreCase).forEach(System.out::println);

		System.out.println("-------------------------");
		System.out.println("By age and currency count");
		customers.stream().sorted(Comparator.comparing(Customer::getAge).reversed()
				//get compare key, compare
				.thenComparing(customer -> customer.getCurrencies().size(), Integer::compareTo))
				.forEach(System.out::println);


	}
}
