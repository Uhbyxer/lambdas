package com.acme.optional;

import com.acme.common.Customer;

import java.util.Collections;
import java.util.Optional;
import java.util.function.Supplier;

import static java.util.Arrays.asList;

public class OptionalDemo {
	public static void main(String[] args) {

		//Returns NLP exception
		try {
			Customer customer = null;
			Optional<Customer> cus = Optional.of(customer);
			System.out.println(cus);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		Supplier<Customer> customerSupplier = () -> new Customer("Zed", "Kiutza", 35, "Dr", asList("EUR", "UAH"));
		Optional<Customer> customerOptional = Optional.ofNullable(customerSupplier.get());

		customerOptional.ifPresent(System.out::println);

		//isPresent
		Optional<String> name = customerOptional.map(Customer::getName);
		name.ifPresent(s -> System.out.println("Name: " + s));

		//Optional.empty
		Optional<Object> empty = Optional.empty();
		System.out.println(empty);

		Customer nullCustomer = null;
		Optional<Customer> nullOptional = Optional.ofNullable(nullCustomer);
		//
		Customer alternativeCustomer = nullOptional.orElse(new Customer("empty", "", 0, "", Collections.emptyList()));
		System.out.println("Alternative: " + alternativeCustomer);
		System.out.println(nullOptional.orElseGet(() -> alternativeCustomer));

		nullOptional.orElseThrow(RuntimeException::new);

	}
}
