package com.java.dsa.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class FindTheNumberOfIslands {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution1 obj = new Solution1();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}


class Solution1 {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int rows = grid.length;
        int cols = grid[0].length;
        int noOfIslands = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (grid[i][j] == '1' && !visited[i][j]){
                    bfs(grid, visited, i, j);
                    noOfIslands++;
                }
            }
        }

        return noOfIslands;
    }

    private void bfs(char[][] grid, boolean[][] visited, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});
        visited[row][col] = true;

        while (!queue.isEmpty()){
            int[] top = queue.poll();
            for (int i=-1; i<=1; i++){
                for (int j=-1; j<=1; j++){
                    int newRow = i + top[0];
                    int newCol = j + top[1];
                    boolean isOutOfBound = newRow<0 || newRow>=rows || newCol<0 || newCol>=cols;
                    if (!isOutOfBound && grid[newRow][newCol] == '1' && !visited[newRow][newCol]){
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

    }
}