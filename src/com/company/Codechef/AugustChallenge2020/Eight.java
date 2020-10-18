package com.company.Codechef.AugustChallenge2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Eight {

    public static void main(String[] args) {
        try {
            new Solver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Solver {
        Solver() throws Exception {
            textCase();
        }

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static ArrayList<Integer> euler = new ArrayList<>();
        static boolean[] vis = new boolean[10];

        private void textCase() throws java.lang.Exception {
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                Vector<Vector<Integer>> graph = new Vector<>(n + 1);
                for (int i = 0; i <= n; i++) {
                    graph.add(new Vector<>());
                }
                for (int i = 1; i < n; i++) {
                    String[] edge = br.readLine().split(" ");
                    addEdge(graph, Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
                }
                String[] p = br.readLine().split(" ");
                String[] a = br.readLine().split(" ");
                String[] b = br.readLine().split(" ");
                int[] permutation = new int[n];
                int[] population = new int[n];
                int[] fruits = new int[n];
                for (int i = 0; i < n; i++) {
                    permutation[i] = Integer.parseInt(p[i]);
                    population[i] = Integer.parseInt(a[i]);
                    fruits[i] = Integer.parseInt(b[i]);
                }
                solve(graph, permutation, population, fruits,n);
            }
        }

        private void solve(Vector<Vector<Integer>> graph, int[] permutation, int[] population, int[] fruits, int n) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < permutation.length; i++) {
                int src = permutation[i];
                eulerTree(src,set,n,graph);
                for (int j = 0; j <euler.size(); j++) {
                    int dest = euler.get(j);
                    if(fruits[dest-1] >0) {
                        int min = Math.min(population[src-1], fruits[dest-1]);
                        fruits[dest - 1] -= min;
                    }
                }
                if(fruits[src-1]==0){
                    System.out.print(src+" ");
                }else {
                    System.out.print(-1+" ");
                }
                set.add(permutation[i]);
            }
            System.out.println();
        }

        private void eulerTree(int src, Set<Integer> set, int n, Vector<Vector<Integer>> graph){
            vis = new boolean[n+1];
            euler = new ArrayList<>();
            euler(src,set,graph);
        }

        private void euler(int src, Set<Integer> set, Vector<Vector<Integer>> graph) {
            vis[src] = true;
            euler.add(src);
            for (int it : graph.get(src)){
                if(!vis[it] && !set.contains(it)){
                    euler(it,set,graph);
                    euler.add(src);
                }
            }
        }

        private void addEdge(Vector<Vector<Integer>> graph, int src, int dest) {
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
    }
}
