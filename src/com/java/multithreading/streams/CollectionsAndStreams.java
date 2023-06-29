package com.java.multithreading.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CollectionsAndStreams {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Rajesh");
        list.add("Carl");
        list.add("Brandon");

        Stream<String> newStream = list.stream();
//        below code will give error
//        newStream.forEach(System.out::println);
//        newStream.forEach(System.out::println);

//        this will work fine
        list.stream().forEach(System.out::println);
        list.stream().forEach(System.out::println);
    }
}
