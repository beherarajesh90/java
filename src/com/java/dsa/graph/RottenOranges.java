package com.java.dsa.graph;

import java.lang.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}

class Solution
{
    //Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        boolean[][] visited = new boolean[rows][cols];

        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (grid[i][j] == 2){
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }
        int minDistance = 0;
        while (!queue.isEmpty()){
            int[] top = queue.poll();
            for (int[] dir : directions){
                int r = top[0] + dir[0];
                int c = top[1] + dir[1];
                minDistance = Math.max(top[2], minDistance);
                boolean isOutOfBound = r<0 || r>=rows || c<0 || c>=cols;
                if (!isOutOfBound && !visited[r][c] && grid[r][c]==1){
                    queue.offer(new int[]{r, c, top[2]+1});
                    visited[r][c] = true;
                }
            }
        }
        boolean allOnesVisited = true;
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    allOnesVisited = false;
                }
            }
        }
        if (allOnesVisited){
            return minDistance;
        }
        return -1;
    }
}