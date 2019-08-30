package com.acme.streamops;

import com.acme.common.Customer;
import com.acme.common.CustomerService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo {
	public static void main(String[] args) {

		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAll();

		customers.forEach(System.out::println);

		//----------------
		System.out.println("> 17");
		customers.stream().filter(customer -> customer.getAge() > 17).forEach(System.out::println);

		//collect
		Map<Customer, String> customerStringMap = customers.stream().filter(customer -> customer.getAge() > 17)
				.collect(Collectors.toMap(Function.identity(), t -> t.getName()));
		System.out.println("Customer Map: " + customerStringMap);

		//map
		Set<Integer> ages = customers.stream().map(Customer::getAge).collect(Collectors.toSet());
		System.out.println("Ages: " + ages);

	}
}
