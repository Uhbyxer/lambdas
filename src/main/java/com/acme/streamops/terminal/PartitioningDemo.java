package com.acme.streamops.terminal;

import com.acme.common.Customer;
import com.acme.common.CustomerService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningDemo {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAll();

		Map<Boolean, List<Customer>> isAdultPartition = customers.stream()
				.collect(Collectors.partitioningBy(o -> o.getAge() >= 18));
		System.out.println("isAdultPartition:");
		System.out.println(isAdultPartition);

		//2 parameter partition
		Map<Boolean, Double> partitionWithAvgAge = customers.stream()
				.collect(Collectors.partitioningBy(o -> o.getAge() >= 18, Collectors.averagingInt(Customer::getAge)));
		System.out.println("partitionWithAvgAge");
		System.out.println(partitionWithAvgAge);

		//Inner partitioning

		Map<Boolean, Map<Boolean, List<Customer>>> adultsGenderPartition =
		customers.stream().collect(Collectors
				.partitioningBy(o -> o.getAge() >= 18, Collectors.partitioningBy(o -> o.getSalutation().equals("Ms"))));

		System.out.println("adultsGenderPartition");
		System.out.println(adultsGenderPartition);
	}
}
