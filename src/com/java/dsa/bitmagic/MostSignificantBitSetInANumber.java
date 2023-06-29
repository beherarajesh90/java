package com.java.dsa.bitmagic;

public class MostSignificantBitSetInANumber {
    public static void main(String[] args) {
        int n =18;
        int closestPowerOf2 = LogBase2Example.logbase2(n);
        System.out.println("Most significant bit set for the number "+n+" is "+(int)Math.pow(2,closestPowerOf2));
    }
}
