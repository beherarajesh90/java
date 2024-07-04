package com.java.multithreading.streams.streamsWithStrings;

import java.util.Comparator;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        String arr[] = {"Rajesh","Prem","Honey","Chandu","ABhi","Swati","Chotu"};

        //comparator works with strings
        Stream.of(arr).filter(x->x.contains("o")).sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
