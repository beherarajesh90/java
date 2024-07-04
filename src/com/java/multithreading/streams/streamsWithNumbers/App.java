package com.java.multithreading.streams.streamsWithNumbers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {

        int arr[]={1,2,3,4,5,6,7,8,9};
        Arrays.stream(arr).sorted().forEach(System.out::print);
        IntStream.range(0,10).filter(ob -> ob>4).sorted().forEach(ob -> System.out.print( ob+" "));
    }
}
