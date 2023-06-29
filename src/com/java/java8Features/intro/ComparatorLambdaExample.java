package com.java.java8Features.intro;

import java.util.Comparator;

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        /**
         * prior java8
         */
        Comparator<Integer> comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("Comparator result : "+comparator.compare(4,4));

        /**
         * java8
         */

        Comparator<Integer> comparator1=(a,b)->a.compareTo(b);
        System.out.println("Comparator result using lambdas : "+comparator1.compare(4,5));
    }
}
