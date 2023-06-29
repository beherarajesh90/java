package com.java.dsa.mathematics;


public class Exactly3Divisors
{
    boolean isPrime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public int exactly3Divisors(int N)
    {

        //Your code here
        int c=0;
        for(int i=2;i*i<=N;i++){
            if(isPrime(i))
                c++;
        }
        return c;

    }
}