package com.company.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Codeforces_1358A {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] w = br.readLine().split(" ");
            int n = Integer.parseInt(w[0]);
            int m = Integer.parseInt(w[1]);
            boolean[][] islight = new boolean[n][m];
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j <m ; j++) {
                    if(j+1 < m){
                       islight[i][j] = true;
                       islight[i][j] = true;
                    }
                }
            }
        }
    }
}
