package com.java.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    // A utility function to add an edge in an
    // undirected graph
    static void addEdge(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void breadthFirstSearch(ArrayList<ArrayList<Integer>> adj, int V){

        //initialize a boolean array to keep track of visited nodes
        boolean[] visited = new boolean[V+1];

        //Mark all vertices not visited
        for (int i=1; i<=V; i++){
            visited[i] = false;
        }

        //Create a queue
        Queue<Integer> queue = new LinkedList<>();

        //start vertex as 1
        int s = 1;

        //add first node to the queue and mark as visited
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()){
            //deque a vertex from the queue and print it
            s = queue.poll();
            System.out.println(s+" ");

            // Traverse the nodes adjacent to the currently
            // popped element and push those elements to the
            // queue which are not already visited
            for (int i=0; i<adj.get(s).size(); i++){
                //fetch adjacent node
                int newNode = adj.get(s).get(i);

                //add element to the queue if it's not visited
                if(!visited[newNode]){
                    visited[newNode] = true;
                    queue.add(newNode);
                }
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
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 3, 5);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 5, 6);

        breadthFirstSearch(adj,V);
    }
}
