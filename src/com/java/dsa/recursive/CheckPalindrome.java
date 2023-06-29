package com.java.dsa.recursive;

public class CheckPalindrome {

    public static boolean isPalindrome(String s,int i){
        if(i > s.length()/2)
        {
            return true ;
        }

        return s.charAt(i) == s.charAt(s.length()-i-1) && isPalindrome(s, i+1) ;
    }

    public static void main(String[] args) {
        String str = "gedseg" ;
        if (isPalindrome(str, 0))
        { System.out.println("Yes"); }
        else
        { System.out.println("No"); }
    }
}
