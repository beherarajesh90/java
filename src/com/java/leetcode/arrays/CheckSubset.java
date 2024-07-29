package com.java.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class CheckSubset {
    public static boolean checkSubset(int[] arr1, int[] arr2, int n, int m) {
        // Write your code here.
        if (m > n) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr1) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (int b : arr2) {
            if (!map.containsKey(b) || map.get(b) <= 0) {
                return false;
            } else {
                map.put(b, map.get(b) - 1);
            }
        }
        return true;
    }
}
