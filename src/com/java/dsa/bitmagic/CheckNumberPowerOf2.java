package com.java.dsa.bitmagic;

public class CheckNumberPowerOf2 {
    public static void main(String[] args) {
        int n = 32;
        int temp = n-1;
        System.out.println((n & temp) == 0? "Power of 2":"No" );
    }
}
