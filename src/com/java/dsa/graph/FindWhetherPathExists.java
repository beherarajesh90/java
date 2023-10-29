package com.java.dsa.graph;

import java.lang.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class FindWhetherPathExists
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            FindWhetherPathExists obj = new FindWhetherPathExists();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    public boolean is_Possible(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[] source = new int[2];
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        //find source index
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (grid[i][j] == 1){
                    source[0] = i;
                    source[1] = j;
                }
            }
        }

        queue.add(source);
        visited[source[0]][source[1]] = true;
        boolean isPath = false;

        while (!queue.isEmpty()){
            int[] top = queue.poll();
            for (int[] d: dir){
                int r = top[0] + d[0];
                int c = top[1] + d[1];
                boolean isOutOfIndex = r <0 || r>=rows || c<0 || c>=cols;
                if (!isOutOfIndex && !visited[r][c]){
                    if(grid[r][c] == 2){
                        visited[r][c] = true;
                        isPath = true;
                        break;
                    }else if(grid[r][c]!=0){
                        visited[r][c] = true;
                        queue.offer(new int[]{r,c});
                    }
                }
            }
        }

        return isPath;
    }
}

