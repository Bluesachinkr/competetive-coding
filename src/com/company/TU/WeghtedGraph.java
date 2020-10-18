package com.company.TU;

import java.util.Arrays;
import java.util.Vector;

public class WeghtedGraph {
    public static void main(String[] args) {
        int INF = 0;
        int graph[][] = {{0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}
        };

        dijkstra(graph, 0);
        System.out.println();
        floyydWarshall(graph);
        System.out.println();
        System.out.println(isCycle(graph));
    }

    private static int find(int[] parent, int src) {
        if (parent[src] == -1) {
            return src;
        }
        return find(parent, parent[src]);
    }

    private static void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    public static boolean isCycle(int[][] graph) {
        int[] parent = new int[graph.length];
        Arrays.fill(parent, -1);

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] != 0) {
                    int x = find(parent, i);
                    int y = find(parent, j);
                    if (x == y) {
                        return true;
                    }
                    union(parent, x, y);
                }
            }
        }
        return false;
    }

    private static void floyydWarshall(int[][] graph) {
        int[][] dist = new int[graph.length][graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 0) {
                    dist[i][j] = Integer.MAX_VALUE;
                } else {
                    dist[i][j] = graph[i][j];
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph.length; k++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printArray(dist);
    }

    private static void printArray(int[][] dist) {
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                if (dist[i][j] != Integer.MAX_VALUE) {
                    System.out.print(dist[i][j] + " ");
                } else if (i == j) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print("INF" + " ");
                }
            }
            System.out.println();
        }
    }

    private static void dijkstra(int[][] graph, int src) {
        boolean[] vis = new boolean[graph.length];

        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        for (int i = 0; i < dist.length - 1; i++) {

            int u = minDist(dist, vis);

            vis[u] = true;

            for (int j = 0; j < graph.length; j++) {
                if (!vis[j] && graph[u][j] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][j] < dist[j]) {
                    dist[j] = dist[u] + graph[u][j];
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + "-" + dist[i]);
        }
    }

    private static int minDist(int[] dist, boolean[] vis) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!vis[i] && dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
}
