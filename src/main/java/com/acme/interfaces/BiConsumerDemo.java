package com.acme.interfaces;

import java.util.function.BiConsumer;

public class BiConsumerDemo {
	public static void main(String[] args) {
		BiConsumer<Integer, Integer> multiplyConsumer = (x, y) -> System.out.println("X * Y = " + x * y);
		BiConsumer<Integer, Integer> printConsumer = (x, y) -> System.out.println("X = " + x + ", Y = " + y);

		multiplyConsumer.andThen(printConsumer).accept(5, 4);
	}
}
