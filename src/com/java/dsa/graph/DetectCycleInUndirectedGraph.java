package com.java.dsa.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DetectCycleInUndirectedGraph {
    static class Graph{
        //no of edges
        private final int v;

        //adjacency list
        private final LinkedList<Integer>[] adj;

        Graph(int v){
            this.v = v;
            adj = new LinkedList[v];
            for (int i=0;i<v; i++){
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int u, int v){
            adj[u].add(v);
            adj[v].add(u);
        }

        public boolean isCycle(){
            boolean[] visited = new boolean[v];
            for (int i=0; i<v; i++){
                if (!visited[i]){
                    if (isCycleUtil( i, -1, visited)){
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean isCycleUtil(int cur, int parent, boolean[] visited) {
            visited[cur] = true;
            Iterator<Integer> itr = adj[cur].iterator();
            while (itr.hasNext()){
                int nextLinkedElement = itr.next();
                if (!visited[nextLinkedElement]){
                    if (isCycleUtil(nextLinkedElement, cur, visited)){
                        return true;
                    }
                }else if (nextLinkedElement!=parent){
                    return true;
                }
            }
            return false;
        }
    }
    public static void main(String args[])
    {

        // Create a graph given
        // in the above diagram
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCycle())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCycle())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}


