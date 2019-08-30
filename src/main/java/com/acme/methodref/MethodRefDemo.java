package com.acme.methodref;

import com.acme.common.Customer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefDemo {
	public static void main(String[] args) {
		Comparator<String> comparator = (o1, o2) -> o1.compareToIgnoreCase(o2);
		//=>
		Comparator<String> newComparator = String::compareToIgnoreCase;

		//===================
		Function<Integer, List<Integer>> integerListFunction = Arrays::asList;

		Supplier<Customer> customerSupplier = Customer::new;
	}
}
