package com.java.multithreading.streams.mappingExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MappingExample {
    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(1,2,3);
        List<Integer> arr2 = Arrays.asList(4,5);

        arr1.stream().flatMap(i->arr2.stream().map(j->Arrays.asList(i,j)))
                .collect(Collectors.toList())
        .forEach(System.out::println);
    }
}
