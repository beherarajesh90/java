package com.java.leetcode.hashmap;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++){
            int currentCharIndex = s.charAt(i) - 'a';
            count[currentCharIndex] = count[currentCharIndex] + 1;
        }
        for (int i=0; i<t.length(); i++){
            int currentCharIndex = t.charAt(i) - 'a';
            if (count[currentCharIndex] == 0){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
    }
}
