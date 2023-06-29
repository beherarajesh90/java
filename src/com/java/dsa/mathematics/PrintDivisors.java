package com.java.dsa.mathematics;

public class PrintDivisors
{
    // method to print the divisors
    static void printDivisors(int n)
    {
        // Note that this loop runs till square root
        for (int i=1; i<=Math.sqrt(n); i++)
        {
            if (n%i==0)
            {
                // If divisors are equal, print only one
                if (n/i == i)
                    System.out.print(" "+ i);

                else // Otherwise print both
                    System.out.print(i+" " + n/i + " " );
            }
        }
    }
//    optimized
//    static void printDivisors(int n)
//    {
//        for(int i=1; i*i <= n; i++)
//        {
//            if(n % i == 0)
//            {
//                System.out.print(i+" ");
//
//                if(i != n / i)
//                    System.out.print((n / i)+" ");
//            }
//        }
//    }

    // Driver method
    public static void main(String args[])
    {
        System.out.println("The divisors of 100 are: ");
        printDivisors(100);;
    }
}