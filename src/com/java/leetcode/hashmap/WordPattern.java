package com.java.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
//    public static boolean wordPattern(String pattern, String s) {
//        Map<Character, String> map  = new HashMap<>();
//        String[] splitString = s.split(" ",-1);
//        boolean res = true;
//        if(pattern.length()!=splitString.length){
//            res = false;
//        }
//        for (int i=0; i<pattern.length(); i++){
//            char currentKey = pattern.charAt(i);
//            String curVal = splitString[i];
//            if (map.containsKey(currentKey)){
//                if (!curVal.equals(map.get(currentKey))){
//                    res = false;
//                }
//            }else if (map.containsValue(curVal)){
//                res = false;
//            }else{
//                map.put(currentKey,curVal);
//            }
//        }
//        return res;
//    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToWord  = new HashMap<>();
        Map<String, Character> wordToChar  = new HashMap<>();
        String[] splitString = s.split(" ",-1);
        boolean res = true;
        if(pattern.length()!=splitString.length){
            res = false;
        }
        for (int i=0; i<pattern.length() && res == true; i++){
            char currentKey = pattern.charAt(i);
            String curVal = splitString[i];
            if(charToWord.containsKey(currentKey)){
                if(!charToWord.get(currentKey).equals(curVal)){
                    res = false;
                }
            }else{
                if(wordToChar.containsKey(curVal)){
                    res = false;
                }
                charToWord.put(currentKey, curVal);
                wordToChar.put(curVal, currentKey);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }
}
