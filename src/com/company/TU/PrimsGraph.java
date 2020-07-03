package com.company.TU;

import java.util.ArrayList;
import java.util.TreeSet;

public class PrimsGraph {

    public static void main(String[] args) {
        PrimsGraph g = new PrimsGraph(7);
        g.addEdge(1, 4, 8);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 2, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(3, 7, 10);
        g.addEdge(4, 6, 9);
        g.addEdge(1, 7, 4);
        g.addEdge(2, 5, 12);
        g.addEdge(4, 7, 6);
        g.primsMst();
    }

    class Node{
        int dest;
        int weight;

        Node(int dest,int weight){
            this.dest =dest;
            this.weight = weight;
        }
    }

    class Vertex{
        int key;
        int vertex;
    }

    class Comparator implements java.util.Comparator<Vertex>{

        @Override
        public int compare(Vertex vertex, Vertex t1) {
            return vertex.key-t1.key;
        }
    }

    private int V;
    private ArrayList<ArrayList<Node>> adj;

    PrimsGraph(int V){
        this.V = V+1;
        this.adj = new ArrayList<>(V+1);
        for (int i = 0; i <=V ; i++) {
            adj.add(new ArrayList<>());
        }
    }

    private void addEdge(int src,int dest,int weight){
        Node s = new Node(src,weight);
        Node d = new Node(dest,weight);
        adj.get(src).add(d);
        adj.get(dest).add(s);
    }

    private void primsMst(){
        int[] parent = new int[V];

        boolean[] mstset = new boolean[V];

        Vertex[] e = new Vertex[V];
        for (int i = 0; i <V ; i++) {
            parent[i] = -1;
            e[i] = new Vertex();
            e[i].key = Integer.MAX_VALUE;
            e[i].vertex = i;
            mstset[i] = false;
        }
        mstset[1] = true;
        e[1].key = 0;

        TreeSet<Vertex> queue = new TreeSet<>(new Comparator());
        for (int i = 1; i <V ; i++) {
            queue.add(e[i]);
        }
        while (!queue.isEmpty()){
            Vertex v = queue.pollFirst();

            mstset[v.vertex] = true;

            for (Node j : adj.get(v.vertex)){
                if(!mstset[j.dest]){
                    if(e[j.dest].key > j.weight){
                        queue.remove(e[j.dest]);
                        e[j.dest].key = j.weight;
                        queue.add(e[j.dest]);
                        parent[j.dest] = v.vertex;
                    }
                }
            }
        }

        for (int i = 2; i <V ; i++) {
            System.out.println(parent[i]+" "+i);
        }
    }
}
