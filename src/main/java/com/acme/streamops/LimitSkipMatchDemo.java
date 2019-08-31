package com.acme.streamops;

import com.acme.common.Customer;
import com.acme.common.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LimitSkipMatchDemo {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAll();

		List<Customer> limitedList = customers.stream().skip(1).limit(2).collect(Collectors.toList());
		System.out.println(limitedList);

		boolean anyUsd = limitedList.stream().anyMatch(customer -> customer.getCurrencies().contains("USD"));
		boolean noneUah = limitedList.stream().noneMatch(customer -> customer.getCurrencies().contains("UAH"));
		boolean allEur = limitedList.stream().allMatch(customer -> customer.getCurrencies().contains("EUR"));

		System.out.format("anyUsd: %s, noneUah: %s, allEur: %s \n", anyUsd, noneUah, allEur);

		Optional<Customer> barSurname = limitedList.stream().filter(customer -> customer.getSurname().equals("Bar")).findAny();
		if (!barSurname.isPresent()) {
			System.out.println("Surname: Bar - no elements");
		}
		Optional<Customer> firstAdult = limitedList.stream().filter(customer -> customer.getAge() > 17).findFirst();
		firstAdult.ifPresent(customer -> {
			System.out.println("Adult found: " + customer);
		});
	}
}
