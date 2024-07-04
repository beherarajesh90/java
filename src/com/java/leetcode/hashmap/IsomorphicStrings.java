package com.java.leetcode.hashmap;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        int[] sArr = new int[128];
        int[] tArr = new int[128];
        int sLen = s.length();
        int tLen = t.length();
        if(sLen!=tLen){
            return false;
        }
        for(int i=0; i<sLen; i++){
            if(sArr[s.charAt(i)] != tArr[t.charAt(i)]){
                return false;
            }
            sArr[s.charAt(i)]=i+1;
            tArr[t.charAt(i)]=i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("aaabbbba","bbbaaaba"));
    }


}
