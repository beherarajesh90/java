package com.java.dsa.bitmagic;

public class CheckKthbitIsSet {
    public static void main(String[] args) {
        int num = 32;
        int k = 6;
        if((num & (1 << (k-1)))>0){
            System.out.printf("%s bit is set",k);
        }
        else{
            System.out.println("Not set");
        }
    }
}
