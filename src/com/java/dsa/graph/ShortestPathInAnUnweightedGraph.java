package com.java.dsa.graph;

import java.util.*;

public class ShortestPathInAnUnweightedGraph {
    // Driver Program
    public static void main(String args[])
    {
        // No of vertices
        int v = 8;

        // Adjacency list for storing which vertices are connected
        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // Creating graph given in the above diagram.
        // add_edge function takes adjacency list, source
        // and destination vertex as argument and forms
        // an edge between them.
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 4, 7);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);
//        int source = 0, dest = 7;
        int source = 2, dest = 6;
        printShortestDistance(adj, source, dest, v);
    }

    // function to form edge between two vertices
    // source and dest
    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j)
    {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    private static void printShortestDistance(ArrayList<ArrayList<Integer>> adj, int s, int d, int v){
        //s source
        //d distance
        //v no of vertices

        int[] pred = new int[v]; //predecessor
        int[] dist = new int[v]; //distance
        Arrays.fill(pred, -1);

        if(!breadthFirstSearch(adj,s,d,v,pred,dist)){
            System.out.println("Source and destination are not collected");
            return;
        }

        List<Integer> path = new ArrayList<>();
        int temp = d;
        path.add(d); // add the destination to the path
        while (pred[temp] != -1){
            path.add(pred[temp]);
            temp = pred[temp];
        }

        System.out.println("Shortest path length is: "+dist[d]);

        for (int i=path.size()-1; i>=0; i--){
            System.out.println(path.get(i)+" ");
        }
    }

    public static boolean breadthFirstSearch(ArrayList<ArrayList<Integer>> adj, int s, int d, int v, int[] pred, int[] dist){

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[v];

        q.add(s);
        dist[s] = 0;
        visited[s] = true;

        while (!q.isEmpty()){
            int cur = q.remove();
            for (int i=0; i<adj.get(cur).size(); i++){
                if(!visited[adj.get(cur).get(i)]){
                    visited[adj.get(cur).get(i)] = true;
                    dist[adj.get(cur).get(i)] = dist[cur]+1;
                    pred[adj.get(cur).get(i)] = cur;
                    q.add(adj.get(cur).get(i));

                    //return if destination found
                    if(adj.get(cur).get(i) == d){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
