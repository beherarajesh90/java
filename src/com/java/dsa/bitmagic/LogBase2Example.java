package com.java.dsa.bitmagic;

public class LogBase2Example {

    public static int logbase2(int n){
        int temp=n;
        int c =0 ;
        while (temp > 1){
            temp = temp >> 1;
            c++;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 32;

        System.out.println("2 power "+logbase2(n)+" is "+n);
    }
}
