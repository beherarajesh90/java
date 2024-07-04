package com.java;

import java.util.Arrays;

public class streams {

    public static void main(String[] args) {
        int[] marks = {43,54,65,43,54,78,98,22};

        long startTime1 = System.currentTimeMillis();
        for(int i=0; i<marks.length; i++){
            if(marks[i]>50)
                System.out.println(marks[i]);
        }
        System.out.printf("took %s \n",System.currentTimeMillis()-startTime1);

        long startTime2 = System.currentTimeMillis();
        Arrays.stream(marks).peek(System.out::println);
        System.out.printf("took %s \n",System.currentTimeMillis()-startTime2);
    }
}
