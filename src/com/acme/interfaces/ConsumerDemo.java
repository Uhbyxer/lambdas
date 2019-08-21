package com.acme.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> stringConsumer = s -> {
            System.out.println(s.toUpperCase());};

        stringConsumer.accept("aaa");

        //********************
        Consumer<String> andThenConsumer = stringConsumer.andThen(s -> {
            System.out.println(s.charAt(0));
        }).andThen(s -> {
            System.out.println("End with " + s);
        });
        andThenConsumer.accept("zzz");

        //*******************************
        List<String> stringList = Arrays.asList("xxx", "yyy");
        stringList.forEach(andThenConsumer);

    }
}
