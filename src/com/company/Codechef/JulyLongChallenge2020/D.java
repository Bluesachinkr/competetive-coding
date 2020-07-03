package com.company.Codechef.JulyLongChallenge2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class D {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0){
                int n = Integer.parseInt(br.readLine().trim());
                int size = 4*n -1;
                int[][] edge = new int[size][2];
                for (int i = 0; i <size ; i++) {
                    String[] s =br.readLine().trim().split(" ");
                    int a  = Integer.parseInt(s[0]);
                    int b = Integer.parseInt(s[1]);
                    edge[i] = new int[]{a,b};
                }
                solution(n,edge);
            }
        }catch (Exception e){
            return;
        }
    }

    private static void solution(int n, int[][] edge) {
        int i = 0;
        while (i < edge.length){

        }
    }
}
