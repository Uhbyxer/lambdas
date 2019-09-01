package com.acme.streamops.generate;

import java.util.Random;
import java.util.stream.Stream;

public class StreamFactoryMethodsDemo {
	public static void main(String[] args) {

		Stream<String> stringStream = Stream.of("one", "two", "three");
		stringStream.forEach(System.out::println);

		Stream.iterate(5, i -> i + 3).limit(5).forEach(System.out::println);

		Stream.generate(Math::random).limit(10).forEach(System.out::println);


	}
}
