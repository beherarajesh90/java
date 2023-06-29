package com.java.multithreading.streams;

import java.util.Arrays;
import java.util.List;

public class FlatMap {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Rajesh","Spencer","Stephane");
        list.stream().map(String::length).forEach(System.out::println);

        List<Integer> list2 = Arrays.asList(1,2,3,4,5);
        list2.stream().map(x->x*x).forEach(System.out::println);

        String arr[] = {"Rajesh","Spencer"};
        Arrays.stream(arr).map(w->w.split("")).flatMap(Arrays::stream)
                .distinct().forEach(System.out::println);
    }
}
