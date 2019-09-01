package com.acme.streamops.generate;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreamsDemo {
	public static void main(String[] args) {
		OptionalDouble average = IntStream.rangeClosed(5, 10).average();
		average.ifPresent(value -> System.out.println("Average: " + value));

		IntStream.range(5, 10).forEach(System.out::println); //[5..9]


		System.out.println("Merged double stream:");
		DoubleStream doubleStream = DoubleStream.iterate(-100, operand -> operand + 2).limit(5);
		DoubleStream randomStream = DoubleStream.generate(Math::random).limit(6);
		DoubleStream.concat(doubleStream, randomStream).forEach(System.out::println);

		List<Integer> integerList = IntStream.range(5, 10).boxed().collect(Collectors.toList());
		System.out.println(integerList);

		OptionalDouble average1 = Stream.iterate(1, integer -> integer + 1).limit(5).mapToInt(Integer::intValue).average();
		System.out.println("average1 = " + average.getAsDouble());

		System.out.println("Map to obj");
		List<Foo> fooList = IntStream.rangeClosed(5, 10).mapToObj(Foo::new).collect(Collectors.toList());
		System.out.println(fooList);
	}

	@Data
	@AllArgsConstructor
	private static class Foo {
		int foo;
	}
}
