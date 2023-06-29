package com.java.dsa.arrays;

public class MaximumAppearingElements {
    public static void main(String[] args) {
        int L[] = {1, 5, 9, 13, 21}, R[] = {15, 8, 12, 20, 30};

        int min=Integer.MIN_VALUE,max=Integer.MAX_VALUE;
        int i=0;
        while (i<L.length){
            if(L[i]>min){
                min = L[i];
            }
            if(R[i]<max){
                max = R[i];
            }
            i++;
        }
        System.out.println(min);
    }
}
