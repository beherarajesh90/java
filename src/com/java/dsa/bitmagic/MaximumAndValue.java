package com.java.dsa.bitmagic;

public class MaximumAndValue {
    public static int checkBit(int pattern, int arr[], int n)
    {
        int count = 0;
        for (int i = 0; i < n; i++)
            if ((pattern & arr[i]) == pattern)
                count++;
        return count;
    }

    // Function for finding maximum and value pair
    public static int maxAND(int arr[], int n)
    {
        int res = 0, count;

        // iterate over total of 32bits from msb to lsb
        for (int bit = 31; bit >= 0; bit--) {
            // find the count of element having same pattern as
            // obtained by adding bits on every iteration.
            count = checkBit(res | (1 << bit), arr, n);

            // if count >= 2 set particular bit in result
            if (count >= 2)
                res = res | (1 << bit); // this is the pattern we continued
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 8, 6, 2 };
        int n = arr.length;
        System.out.println("Maximum AND Value = " + maxAND(arr, n));
    }
}
