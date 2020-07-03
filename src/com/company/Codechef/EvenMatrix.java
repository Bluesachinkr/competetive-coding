package com.company.Codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class EvenMatrix {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                int[][] res = Solution(n);
                for (int i = 0; i <res.length ; i++) {
                    for (int j = 0; j <res.length ; j++) {
                        System.out.print(res[i][j]+" ");
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
        } finally {
        }
    }

    static int[][] Solution(int n) {
        int[][] M = new int[n][n];
        int nextnumber = 1;
        for (int i = 0; i < M.length; i++) {
            M[0][i] = nextnumber;
            nextnumber++;
        }
        for (int i = 0; i < M.length-1; i++) {
            for (int j = 0; j < M.length-1; j++) {
                if (((M[i][j] % 2 == 0) && (nextnumber % 2 == 0)) || ((M[i][j] % 2 != 0) && (nextnumber % 2 != 0))) {
                    M[i + 1][j + 1] = nextnumber;
                    nextnumber++;
                }
                if (M[i + 1][j] == 0) {
                    M[i + 1][j] = nextnumber;
                    nextnumber++;
                }
            }
            if(M[i+1][M.length-1]==0){
                M[i+1][M.length-1] = nextnumber;
                nextnumber++;
            }
        }
        return M;
    }
}
