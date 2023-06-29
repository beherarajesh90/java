package com.java.dsa.mathematics;

//Time Complexity: O(log y)
public class PowerEfficientApproach {
    public static int power(int x,int n){
        int res = 1;
        while (n>0){
            if(n%2!=0) res = res * x;
            n = n >> 1;
            x = x * x;
        }
        return res;

    }
    public static void main(String[] args) {
        System.out.println(power(5,4));
    }
}
