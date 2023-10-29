package com.java.dsa.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {

    //Function to find distance of nearest 1 in the grid for each cell.
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[rows][cols];
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (grid[i][j]==1){
                    visited[i][j] = true;
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        while (!q.isEmpty()){
            int[] arr = q.remove();
            int r = arr[0];
            int c = arr[1];
            int d = arr[2];
            dist[r][c] = d;
            for (int[] dir: directions){
                int i = r + dir[0];
                int j = c + dir[1];
                boolean isOutOfBound = i<0 || i >=rows || j<0 || j>=cols;

                if(isOutOfBound || visited[i][j]) continue;

                q.offer(new int[]{i,j,d+1});
                visited[i][j] = true;
            }
        }
        return dist;
    }

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
            DistanceOfNearestCellHaving1 obj = new DistanceOfNearestCellHaving1();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
