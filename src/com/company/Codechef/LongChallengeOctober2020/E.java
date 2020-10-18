package com.company.Codechef.LongChallengeOctober2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class E {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int d = Integer.parseInt(s[1]);
            int[][] dim = new int[n][d];
            for (int i = 0; i < n; i++) {
                String[] sk = br.readLine().trim().split(" ");
                for (int j = 0; j < d; j++) {
                    dim[i][j] = Integer.parseInt(sk[j]);
                }
            }
            if (n == 1) {
                System.out.println(0);
            } else {
                long[][] graph = new long[n][n];
                makeGraph(graph, dim, d);
                //prims mst
                primsMst(graph);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void primsMst(long[][] graph) {
        long[] key = new long[graph.length];

        boolean[] mstSet = new boolean[graph.length];

        Arrays.fill(key, -1);

        key[0] = 0;

        for (int i = 0; i < graph.length - 1; i++) {
            int u = maxKey(key, mstSet);
            mstSet[u] = true;
            for (int j = 0; j < graph.length; j++) {
                if (!mstSet[j] && graph[u][j] > key[j]) {
                    key[j] = graph[u][j];
                }
            }
        }
        long res = 0;
        for (int i = 0; i < key.length; i++) {
            res += key[i];
        }
        System.out.println(res);
    }

    private static int maxKey(long[] key, boolean[] mstSet) {
        long max = -1;
        int index = -1;
        for (int i = 0; i < key.length; i++) {
            if (!mstSet[i] && key[i] > max) {
                max = key[i];
                index = i;
            }
        }
        return index;
    }

    private static void makeGraph(long[][] graph, int[][] dim, int d) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                long w = weight(dim, i, j, d);
                graph[i][j] = w;
            }
        }
    }

    private static long weight(int[][] dim, int i, int j, int d) {
        long weight = 0;
        for (int k = 0; k < d; k++) {
            weight += Math.abs(dim[i][k] - dim[j][k]);
        }
        return weight;
    }
}
