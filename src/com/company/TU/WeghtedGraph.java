package com.company.TU;

import java.util.ArrayList;
import java.util.Arrays;

public class WeghtedGraph {
    public static void main(String[] args) {
        WeghtedGraph g = new WeghtedGraph(7, 9);
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            adj.add(new ArrayList<>());
        }
        g.addEdge(1, 4, 8, 0);
        g.addEdge(2, 4, 7, 1);
        g.addEdge(3, 2, 6, 2);
        g.addEdge(1, 2, 2, 3);
        g.addEdge(3, 7, 10, 4);
        g.addEdge(4, 6, 9, 5);
        g.addEdge(1, 7, 4, 6);
        g.addEdge(2, 5, 12, 7);
        g.addEdge(4, 7, 6, 8);
        g.kruskalMst();
    }

    private void kruskalMst() {
        Edge[] res = new Edge[V - 1];
        int e = 0;

        Arrays.sort(edges);
        Subset[] subsets = new Subset[V];
        for (int i = 0; i < subsets.length; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int i = 0;
        while (e < V - 1 && i < edges.length) {
            Edge ed = edges[i++];

            int x = find(subsets, ed.src);
            int y = find(subsets, ed.dest);

            if (x != y) {
                res[e++] = ed;
                union(subsets, x, y);
            }
        }

        for (int j = 0; j < e; j++) {
            System.out.println(res[j].src + " " + res[j].dest);
        }
    }

    private void union(Subset[] subsets, int x, int y) {
        int xs = find(subsets, x);
        int ys = find(subsets, y);

        if (subsets[xs].rank < subsets[ys].rank) {
            subsets[xs].parent = ys;
        } else if (subsets[xs].rank > subsets[ys].rank) {
            subsets[ys].parent = xs;
        } else {
            subsets[xs].parent = ys;
            subsets[xs].rank++;
        }
    }

    private int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    class Edge implements Comparable<Edge> {
        int src;
        int weight;
        int dest;

        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

    class Subset {
        int parent;
        int rank;
    }

    private Edge[] edges;
    private int V;
    private int E;
    private ArrayList<ArrayList<Edge>> adj;

    WeghtedGraph(int V, int E) {
        this.V = V + 1;
        this.E = E;
        edges = new Edge[E];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new Edge();
        }
        adj = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
            adj.get(i).add(new Edge());
        }
    }

    private void addEdge(int src, int dest, int weight, int no) {
        edges[no].src = src;
        edges[no].dest = dest;
        edges[no].weight = weight;
        adj.get(src).add(edges[no]);
        adj.get(dest).add(edges[no]);
    }

}
