package com.java.leetcode.matrix;

public class SearchInARowColumnSortedMatrix {
    public static boolean search(int[][] mat, int n, int m, int x)
    {

        // set indexes for top right
        int i = 0, j = m - 1;
        // element

        while (i < n && j >= 0)
        {
            if (mat[i][j] == x)
            {
                return true;
            }
            if (mat[i][j] > x)
                j--;
            else // if mat[i][j] < x
                i++;
        }

        return false; // if ( i==n || j== -1 )
    }

    public static void main(String[] args) {
         int[][] m = {
                 {63, 15, 25, 25, 26, 37, 42, 45, 46, 66},
                 {78, 27, 32, 41, 44, 51, 51, 56, 60, 77}};

         boolean res = search(m,2,10,60);
         System.out.println(res);
    }
}
