package com.company;

import java.util.*;

public class Graph {
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.dfs(2);
        g.bfs(2);
    }

    private Vector<Vector<Integer>> graph;
    private int size;

    public Graph(int size) {
        this.size = size + 1;
        this.graph = new Vector<>(this.size);
        for (int i = 0; i < this.size; i++) {
            graph.add(new Vector<>());
        }
    }

    public void addEdge(int from, int to) {
        graph.get(from).add(to);
        graph.get(to).add(from);
    }

    public void remove(int from, int to) {
        graph.get(from).removeElement(to);
        graph.get(to).removeElement(from);
    }

    public void bfs(int src) {
        boolean[] vis = new boolean[this.size];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        vis[src] = true;

        while (!queue.isEmpty()) {
            int val = queue.poll();
            System.out.print(val + " ");

            Iterator<Integer> i = graph.get(val).listIterator();
            while (i.hasNext()) {
                int s = i.next();
                if (!vis[s]) {
                    queue.add(s);
                    vis[s] = true;
                }
            }
        }
        System.out.println();
    }

    public void dfs(int src) {
        boolean[] vis = new boolean[this.size];
        dfsUtil(graph, src, vis);
        System.out.println();
    }

    private void dfsUtil(Vector<Vector<Integer>> graph, int src, boolean[] vis) {
        vis[src] = true;
        System.out.print(src + " ");

        Iterator<Integer> i = graph.get(src).listIterator();
        while (i.hasNext()) {
            int val = i.next();
            if (!vis[val]) {
                dfsUtil(graph, val, vis);
            }
        }
    }
}
