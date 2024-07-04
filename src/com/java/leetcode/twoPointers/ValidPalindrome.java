package com.java.leetcode.twoPointers;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        boolean res = true;
        while(start<=end && start < s.length() && end >= 0){
            while (start<=end && start < s.length() && end >= 0 &&
                    !((s.charAt(start) >= 65 && s.charAt(end) <= 90) ||
                            (s.charAt(start) >= 97 && s.charAt(start) <= 122))) {
                start++;
            }

            while (start<=end && start < s.length() && end >= 0 &&
                    !((s.charAt(end) >= 65 && s.charAt(end) <= 90) ||
                            (s.charAt(end) >= 97 && s.charAt(end) <= 122))) {
                end--;
            }

            if (s.charAt(start) != s.charAt(end)) {
                res = false;
                break;
            }
            start++;
            end--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(" "));
    }
}
