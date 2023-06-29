package com.java.java11Features;

import java.util.ArrayList;

public class ListToArray {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList();
        list.add(2);
        list.add(1);
        list.add(3);

        Integer[] arr1 = list.stream().toArray(size -> new Integer[size]);

        Integer[] arr2 = list.toArray(size -> new Integer[size]);

        for(int i=0; i<arr2.length; i++){
            System.out.println(arr2[i]);
        }

    }
}
