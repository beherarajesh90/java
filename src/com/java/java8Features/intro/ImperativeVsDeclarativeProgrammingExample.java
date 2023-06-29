package com.java.java8Features.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImperativeVsDeclarativeProgrammingExample {
    public static void main(String[] args) {
        /**
         * Imperative Programming
         */
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,0,3,4,5,7,8);
        List<Integer> uniqueList=new ArrayList<>();

        for(int element:list){
            if(!uniqueList.contains(element)){
                uniqueList.add(element);
            }
        }
        System.out.println("Imperative Programming "+uniqueList);

        /**
         * Declarative Programming
         */
        List<Integer> uniqList1=list.stream().distinct().toList();
        System.out.println("Declarative Programming "+uniqList1);

    }
}
