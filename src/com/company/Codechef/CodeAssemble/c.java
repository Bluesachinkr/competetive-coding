package com.company.Codechef.CodeAssemble;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class c {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           String[] s = br.readLine().trim().split(" ");
           int n = Integer.parseInt(s[0]);
           int m = Integer.parseInt(s[1]);
           String[] arr = new String[n];
            for (int i = 0; i < n ; i++) {
                String sr = br.readLine().trim();
                arr[i] = sr;
            }
            int q = Integer.parseInt(br.readLine().trim());
            int[][] queries = new int[q][4];
            for (int i = 0; i <q ; i++) {
                String[] b = br.readLine().split(" ");
                queries[i][0] = Integer.parseInt(b[0]);
                queries[i][1] = Integer.parseInt(b[1]);
                queries[i][2] = Integer.parseInt(b[2]);
                queries[i][3] = Integer.parseInt(b[3]);
            }
            solution(arr,n,m,queries);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void solution(String[] at,int n,int m, int[][] queries) {
        int[][] arr = new int[n][m];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0]-1;
            int b = queries[i][1]-1;
            int c  = queries[i][2]-1;
            int d = queries[i][3]-1;
            for (int j = a; j <=c ; j++) {
                for (int k = b; k <=d ; k++) {
                    arr[j][k]++;
                }
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if((arr[i][j] & 1) == 0){
                    if(at[i].charAt(j) == '1'){
                        System.out.print(0);
                    }else{
                        System.out.print(1);
                    }
                }
                System.out.print(at[i].charAt(j));
            }
            System.out.println();
        }
    }
}
