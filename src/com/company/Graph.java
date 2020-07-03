package com.company;

import java.util.*;

public class Graph {

    public static void main(String[] args) {
        Graph g=new Graph(8);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(3,2);
        g.addEdge(4,6);
        g.addEdge(1,5);
        g.addEdge(7,8);
        g.addEdge(8,6);
        g.addEdge(4,8);
        g.bfs();
        System.out.println("----");
        g.dfs();
    }
    private ArrayList<ArrayList<Integer>> adj;
    private int size;
    Graph(int size){
        this.size = size;
        adj= new ArrayList<>(size+1);
        for (int i = 0; i <=size ; i++) {
            adj.add(new ArrayList<>());
        }
    }

    private void addEdge(int src,int dest){
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }

    private void bfs(){
        boolean[] vis=new boolean[size+1];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        vis[1] = true;
        while (!queue.isEmpty()){
            int s = queue.poll();
            System.out.print("Vertex:"+" "+s+"\t"+"child:"+" ");
            for (int i = 0; i <adj.get(s).size() ; i++) {
                if(!vis[adj.get(s).get(i)]){
                    System.out.print(adj.get(s).get(i)+" ");
                    queue.add(adj.get(s).get(i));
                    vis[adj.get(s).get(i)]=true;
                }
            }
            System.out.println();
        }
    }

    private void dfs(){
        Set<Integer> set=new HashSet<>();
        for (int i = 1; i <adj.size() ; i++) {
            if(!set.contains(i)){
                set.add(i);
                dfsUtil(i,set);
            }
        }
    }

    private void dfsUtil(int start,Set<Integer> set){
        Stack<Integer> s=new Stack<>();
        s.add(start);
        set.add(start);
        while (!s.isEmpty()){
            int r = s.pop();
            System.out.println(r);
            Iterator<Integer> i = adj.get(r).iterator();
            while (i.hasNext()){
                int rst = i.next();
                if(!set.contains(rst)) {
                    s.add(rst);
                    set.add(rst);
                }
            }
        }
    }
}
