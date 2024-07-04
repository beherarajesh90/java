package com.java.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample<T> {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        List<Integer> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l2.add("Hello");
        l2.add("World");
        GenericsExample<Integer> s1 = new GenericsExample<>();
        GenericsExample<String> s2 = new GenericsExample<>();
        s1.printArray(l1);
        s2.printArray(l2);
    }

    public void printArray(List<T> list) {
        list.forEach(ob -> System.out.println(ob));
    }
}
