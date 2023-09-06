package com.java.dsa.graph;

import java.util.*;

public class DepthFirstSearch {
    // A utility function to add an edge in an
    // undirected graph
    static void addEdge(ArrayList<ArrayList<Integer>> adj,
                        int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void depthFirstSearch(ArrayList<ArrayList<Integer> > adj, int V, int s){
        boolean[] visited = new boolean[V];
        depthFirstSearchUtil(adj,visited,s);
    }

    public static void depthFirstSearchUtil(ArrayList<ArrayList<Integer> > adj, boolean[] visited, int s){

        visited[s] = true;
        System.out.print(s+" ");

        for (int n : adj.get(s)) {

            if (!visited[n]) {
                depthFirstSearchUtil(adj, visited, n);
            }
        }

    }

    public static void main(String[] args) {

        // Creating a graph with 6 vertices
        int V = 6;
        ArrayList<ArrayList<Integer> > adj
                = new ArrayList<ArrayList<Integer> >(V+1);

        for (int i = 0; i < V+1; i++)
            adj.add(new ArrayList<Integer>());

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 3);

        depthFirstSearch(adj,V,2);
    }
}
