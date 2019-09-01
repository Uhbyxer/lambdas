package com.acme.parallel;

import com.acme.common.Customer;
import com.acme.common.CustomerService;


import java.util.List;

import  java.lang.Thread;
import java.util.Random;
import java.util.stream.IntStream;

public class ParallelDemo {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.getAll();

		customers.parallelStream().forEach(customer -> {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + ". " + customer);
		});

		IntStream.generate(() -> new Random().nextInt()).parallel().limit(100).forEach(
				value -> {
					String threadName = Thread.currentThread().getName();
					System.out.println(threadName + ". " + value);
				}
		);

		System.out.println("Number of processors = " + Runtime.getRuntime().availableProcessors());

	}
}
