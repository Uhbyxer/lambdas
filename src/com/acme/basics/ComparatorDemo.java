package com.acme.basics;

import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        Comparator<Integer> integerComparator = (o1, o2) -> o1.compareTo(o2);
        Comparator<Integer> naturalComparator = Comparator.naturalOrder();

        System.out.println(integerComparator.compare(5, 6));
        System.out.println(naturalComparator.compare(5, 6));
    }
}
