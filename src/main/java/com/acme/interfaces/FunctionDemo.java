package com.acme.interfaces;

import com.acme.common.Customer;
import com.acme.common.CustomerService;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionDemo {
	public static void main(String[] args) {
		Function<Customer, String> fullNameFunction = customer -> String
				.join(" ", customer.getSalutation(), customer.getName(), customer.getSurname());

		Function<Customer, String> greetingFunction =
		fullNameFunction.andThen(s -> s.concat("."))
						.compose(customer -> {
							customer.setSalutation(customer.getSalutation().toUpperCase());
							return customer;
						});

		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAll();

		customers.stream().map(greetingFunction).forEach(System.out::println);

		//************
		Function<Customer, Customer> identity = Function.identity();
		System.out.println(identity.apply(customers.get(0)));

		BiFunction<Customer, Integer, String> biFunction = (customer, integer) -> String
				.format("Customer %s has %d dollars", customer.getSurname(), integer);
		System.out.println(biFunction.apply(customers.get(0), 100));
	}
}
