package com.java.dsa.mathematics;

/*
* Efficient approach: To check whether  the number is prime or not follow the below idea:
*In the previous approach given if the size of the given number is too large then its square root will be
* also very large, so to deal with large size input we will deal with a few numbers such as 1, 2, 3, and
* the numbers which are divisible by 2 and 3 in separate cases and for remaining numbers, we will iterate
* our loop from 5 to sqrt(n) and check for each iteration whether that  (iteration) or (that iteration + 2)
* divides n or not. If we find any number that divides, we return false.
*Time complexity: O(sqrt(n))
*Auxiliary space: O(1)
*
* */

public class CheckForPrime {
    public static boolean isPrime(int n){
        if(n<=1) return false;
        if(n==2 || n==3) return true;
        if(n%2==0 || n%3==0) return false;
        for (int i=5;i<=Math.sqrt(n);i=i+6){
            if(n%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(132));
    }
}
