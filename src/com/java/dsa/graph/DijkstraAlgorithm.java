package com.java.dsa.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }

            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

            int S = Integer.parseInt(read.readLine());

            DijkstraAlgorithm ob = new DijkstraAlgorithm();

            int[] ptr = ob.dijkstra(V, adj, S);

            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class DijkstraAlgorithm
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.

    class Pair{
        private int index;
        private int weight;

        public Pair(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
    int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getWeight));
        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        Pair pair = new Pair(S, 0);
        pq.add(pair);
        result[S] = 0;
        while (!pq.isEmpty()){
            Pair top = pq.poll();
           for (ArrayList<Integer> node : adj.get(top.getIndex())){
               if (result[node.get(0)] > (result[top.getIndex()] + node.get(1))){
                   result[node.get(0)] = (result[top.getIndex()] + node.get(1));
                   Pair newPair = new Pair(node.get(0), node.get(1));
                   pq.add(newPair);
               }
           }
        }

        return result;
    }
}


