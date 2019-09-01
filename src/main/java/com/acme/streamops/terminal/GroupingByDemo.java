package com.acme.streamops.terminal;

import com.acme.common.Customer;
import com.acme.common.CustomerService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingByDemo {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAll();

		Map<Integer, List<Customer>> groupByAge = customers.stream().collect(Collectors.groupingBy(Customer::getAge));
		groupByAge.forEach((age, elements) -> System.out.println("Age: " + age + ", customers: " + elements));

		// **********************
		System.out.println("By Custom key:");
		Map<String, List<Customer>> groupByAdults = customers.stream()
				.collect(Collectors.groupingBy(o -> o.getAge() >= 18 ? "adults" : "kids"));
		groupByAdults.forEach((age, elements) -> System.out.println("Age: " + age + ", customers: " + elements));

		// **********************
		System.out.println("Two level grouping");
		Map<String, Map<String, List<Customer>>> twoLevelGroup = customers.stream().collect(Collectors
				.groupingBy(o -> o.getAge() >= 18 ? "adults" : "kids", Collectors.groupingBy(Customer::getSalutation)));

		twoLevelGroup.forEach((age, stringListMap) -> {
			System.out.println("Age group: " + age);
			stringListMap.forEach((salutation, elements) -> System.out
					.println("\tSalutation: " + salutation + ", customers: " + elements));
		});

		System.out.println("Group by count");
		Map<String, Integer> integerMap = customers.stream()
				.collect(Collectors.groupingBy(Customer::getSalutation, Collectors.summingInt(value -> 1)));
		System.out.println(integerMap);

		//Three params
		System.out.println("Three params grouping");
		LinkedHashMap<String, Set<Customer>> threeParamGroup = customers.stream().collect(Collectors
				.groupingBy(o -> o.getAge() >= 18 ? "adults" : "kids", LinkedHashMap::new, Collectors.toSet()));

		threeParamGroup.forEach((age, set) -> {
			System.out.println("Age group: " + age + ", set: " + set);
		});
	}
}
