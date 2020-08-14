package com.company.Codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Pappu {
    public static void main(String[] args) throws java.lang.Exception {
        try{
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0){
                int n = Integer.parseInt(br.readLine().trim());
                int size = 4*n  -1;
                int[][] edges = new int[size][2];
                for (int i = 0; i <size ; i++) {
                    String[] s = br.readLine().split(" ");
                    int a = Integer.parseInt(s[0]);
                    int b = Integer.parseInt(s[1]);
                    edges[i] = new int[]{a,b};
                }
                solution(edges , n);
            }
        }catch (Exception e){
            System.out.println("lelo");
        }
    }

    static class Vertex{
        int x;
        int y;
        Vertex(){}
        Vertex(int x,int y){
            this.x =x;
            this.y =y;
        }
    }

    private static void solution(int[][] edges, int n) {
        HashSet<Vertex> set = new HashSet<>();
        for (int i = 0; i <edges.length ; i++) {
            Vertex v = new Vertex();
            v.x = edges[i][0];
            v.y = edges[i][1];
            if(!set.contains(v)){
                int j = i+1;
                while (j < edges.length){
                    if(edges[i][0] == v.x){

                    }
                    if(edges[i][1] == v.y){

                    }
                }
            }
        }
    }
}
