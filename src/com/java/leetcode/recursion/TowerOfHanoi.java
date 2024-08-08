package com.java.leetcode.recursion;

public class TowerOfHanoi {
    public static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod){
        if(n==0) return;
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
        System.out.printf("move disc %s from %s to %s\n", n, from_rod, to_rod);
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
    }

    public static void main(String[] args) {
        towerOfHanoi(2,'A','C','B');
    }


}
