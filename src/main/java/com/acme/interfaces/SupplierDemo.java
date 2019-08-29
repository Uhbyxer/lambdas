package com.acme.interfaces;

import java.util.function.Supplier;

public class SupplierDemo {
	public static void main(String[] args) {
		Supplier<String> supplier = () -> "Hello world !";
		System.out.println(supplier.get());
	}
}
