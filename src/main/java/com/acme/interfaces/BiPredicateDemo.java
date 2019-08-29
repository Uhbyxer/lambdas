package com.acme.interfaces;

import com.acme.common.Customer;
import com.acme.common.CustomerService;

import java.util.List;
import java.util.function.Predicate;

public class BiPredicateDemo {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAll();

		Predicate<Customer> adults = (customer) -> customer.getAge() >= 18;
		Predicate<Customer> does = (customer) -> "Doe".equals(customer.getSurname());

		customers.stream().filter(adults.and(does)).forEach(System.out::println);
		System.out.println("Not adults");
		customers.stream().filter(adults.negate().and(does)).forEach(System.out::println);


	}

}
