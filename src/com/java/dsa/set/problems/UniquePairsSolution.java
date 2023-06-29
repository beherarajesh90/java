package com.java.dsa.set.problems;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UniquePairsSolution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        //Write your code here
        int size = pair_left.length;
        Set<Set<String>> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            Set<String> temp = new HashSet<>();
            temp.add(pair_left[i] + "_" + pair_right[i]);
            set.add(temp);
            System.out.println(set.size());
        }

    }
}