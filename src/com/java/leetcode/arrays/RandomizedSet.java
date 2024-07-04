package com.java.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {

        private Map<Integer, Integer> map;
        public RandomizedSet() {
                map = new HashMap<>();
        }

        public boolean insert(int val) {
                if (map.containsKey(val)){
                        return false;
                }
                map.put(val,1);
                return true;
        }

        public boolean remove(int val) {
                if (map.containsKey(val)){
                        map.remove(val);
                        return true;
                }
                return false;
        }

        public int getRandom() {
                return 0;
        }

        public static void main(String[] args) {
                RandomizedSet set = new RandomizedSet();
                System.out.println(set.insert(1));
                System.out.println(set.insert(3));
                System.out.println(set.insert(4));
                System.out.println(set.insert(2));
                System.out.println(set.remove(3));
                List<Integer> l = new ArrayList<>();
                System.out.println(l.size());
//                System.out.println(set.getRandom());
        }
}


