package com.company.Codechef.AugustChallenge2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class One {
    public static void main(String[] args){
        try{
            new Solver();
        }catch (Exception e){
         return;
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
            while (t-- >0){
                String[] w = br.readLine().trim().split(" ");
                int h = Integer.parseInt(w[0]);
                int p = Integer.parseInt(w[1]);
                solution(h,p);
            }
        }

        private static void solution(int h, int p) {
            while (p > 0){
                h-=p;
                p/=2;
            }
            if(p==0 && h>0){
                System.out.println(0);
            }else{
                System.out.println(1);
            }
        }
    }
}