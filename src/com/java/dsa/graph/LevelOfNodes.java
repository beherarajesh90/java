package com.java.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOfNodes
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();

            LevelOfNodes ob = new LevelOfNodes();

            System.out.println(ob.nodeLevel(V,list,X));
        }
    }

    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int level = -1;
        queue.add(new int[]{0,0});
        visited[0] = true;
        while (!queue.isEmpty()){
            int[] top = queue.poll();
            if(X == top[0]){
                level = top[1];
                break;
            }
            if(!visited[top[0]]){
                visited[top[0]] = true;
            }
            for (Integer node : adj.get(top[0])){
                if(!visited[node]){
                    queue.offer(new int[]{node, top[1]+1});
                }
            }
        }

        return level;
    }
}
