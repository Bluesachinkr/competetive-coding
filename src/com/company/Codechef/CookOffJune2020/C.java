package com.company.Codechef.CookOffJune2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class C {
    public static void main(String[] args) throws java.lang.Exception {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0){
                String[] w = br.readLine().trim().split(" ");
                int n = Integer.parseInt(w[0]);
                int m = Integer.parseInt(w[1]);
                String[] s1 = br.readLine().split(" ");
                String[] s2 = br.readLine().split(" ");
                ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n+1);
                for (int i = 0; i <=n; i++) {
                    adj.add(new ArrayList<Integer>());
                }
                while (m-- > 0){
                    String[] s3 = br.readLine().trim().split(" ");
                    addEdge(adj,Integer.parseInt(s3[0]),Integer.parseInt(s3[1]));
                }
                int res = 0;
                ArrayList<Integer> ansF = new ArrayList<>();
                for (int i = 1; i < adj.size() ; i++) {
                    ArrayList<Integer> ans = new ArrayList<>();
                    int r = bfs(adj,n,s1,s2,ans);
                    if(r >=res){
                        res = r;
                        ansF = ans;
                    }
                }
                System.out.println(res);
                for (int i = 0; i <ansF.size() ; i++) {
                    System.out.print(ansF.get(i)+" ");
                }
            }
        }catch (Exception e){
            return;
        }
    }

    private static int bfs(ArrayList<ArrayList<Integer>> adj, int n, String[] a, String[] b, ArrayList<Integer> ans) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int denom = 0;
        boolean[] vis = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()){
            int val = queue.poll();
            vis[val] = true;
            sum+=Integer.parseInt(a[val-1]);
            denom+=Integer.parseInt(b[val-1]);
            max = sum/denom;
            ArrayList<Integer> adjacent = adj.get(val);
            int tempSol = max;
            int next = -1;
            ans.add(val);
            for (int i = 0; i <adjacent.size() ; i++) {
                int s = adjacent.get(i);
                if(!vis[s]){
                    int u = sum+Integer.parseInt(a[s-1]);
                    int d = denom+Integer.parseInt(b[s-1]);
                    if((u/d) >=tempSol){
                        tempSol = u/d;
                        next = s;
                    }
                }
            }
            if(next !=-1){
                queue.add(next);
            }
         }
        return max;
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int ini, int fin){
        adj.get(ini).add(fin);
        adj.get(fin).add(ini);
    }
}