package com.java.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomeNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0; i<magazine.length(); i++){
            char c = magazine.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
            }
        }
        boolean res = true;
        for (Character ch : map.keySet()){
            if (map.get(ch)>0){
                res = false;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        boolean res = canConstruct("aafa","aabff");
        System.out.println(res);
    }
}
