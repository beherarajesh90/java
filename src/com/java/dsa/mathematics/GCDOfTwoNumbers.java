package com.java.dsa.mathematics;


public class GCDOfTwoNumbers {
//A simple and old  approach is the Euclidean algorithm by subtraction
//    public static int gcd(int a, int b){
//        //handle zero case
//        //everything divides zero
//        if(a==0) return b;
//
//        if(b==0) return a;
//
//        //base case
//        if(a==b) return a;
//        if(a>b) return  gcd(a-b,b);
//        return gcd(a,b-a);
//    }
    //better approach
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        System.out.println("GCD of 98 and 56 is "+gcd(98,56));
    }
}
