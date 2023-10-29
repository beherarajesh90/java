package com.java.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DetectCycleInDirectedGraph {

    static class Graph{
        private final int v;
        private final List<List<Integer>> adj;

        Graph(int v){
            this.v = v;
            adj = new ArrayList<>();
            for (int i=0; i<v; i++){
                adj.add(new LinkedList<>());
            }
        }

        public void addEdge(int source, int dest){
            adj.get(source).add(dest);
        }

        public boolean isCycle(){
            boolean[] visited = new boolean[v];
            boolean[] recursionStack = new boolean[v];

            for (int i=0; i<v; i++){
                if (isCycleUtil(i, visited, recursionStack))
                    return true;
            }
            return false;
        }

        private boolean isCycleUtil(int i, boolean[] visited, boolean[] recursionStack) {

            if(recursionStack[i]){
                return true;
            }
            if (visited[i]){
                return false;
            }
            visited[i] = true;
            recursionStack[i] = true;

            List<Integer> children = adj.get(i);

            for (Integer c: children){
                if(isCycleUtil(c, visited, recursionStack))
                    return true;
            }
            recursionStack[i] = false;
            return false;
        }
    }

    public static void main(String[] args)
    {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(graph.isCycle())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}

