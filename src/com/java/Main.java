package com.java;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        // Write your code here

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int N = sc.nextInt();
        System.out.println("Enter choice");
        int C = sc.nextInt();


        if(C==1){
            int total=0;

            for(int num=1; num<=N; num++){
                total=total+num;
            }
            System.out.println(total);

        }else if(C==2){
            int product=1;

            for(int num=1; num<=N; num++){
                product=product*num;
            }
            System.out.println(product);

        }else{
            System.out.println("-1");

        }


    }
}















