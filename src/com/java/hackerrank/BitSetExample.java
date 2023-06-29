package com.java.hackerrank;

import java.util.*;

public class BitSetExample {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        BitSet bs1 = new BitSet(n);
        BitSet bs2 = new BitSet(n);
        BitSet[] bsArr = {bs1, bs2};
        while (m-- >= 1) {
            String operation = sc.next();
            int firstArg = sc.nextInt();
            int secArg = sc.nextInt();
            if (operation.equals("AND")) {
                bsArr[firstArg - 1].and(bsArr[secArg - 1]);
            } else if (operation.equals("OR")) {
                bsArr[firstArg - 1].or(bsArr[secArg - 1]);
            } else if (operation.equals("XOR")) {
                bsArr[firstArg - 1].xor(bsArr[secArg - 1]);
            } else if (operation.equals("FLIP")) {
                bsArr[firstArg - 1].flip(secArg);
            } else if (operation.equals("SET")) {
                bsArr[firstArg - 1].set(secArg);
            }

            System.out.println(bs1.cardinality() + " " + bs2.cardinality());
        }
    }
}
