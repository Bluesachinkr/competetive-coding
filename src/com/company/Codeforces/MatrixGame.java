package com.company.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MatrixGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            solve(br);
        }
    }

    private static void solve(BufferedReader br) throws IOException {
        String[] word = br.readLine().split(" ");
        int n = Integer.parseInt(word[0]);
        int m = Integer.parseInt(word[0]);
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().trim().split(" ",m);
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals("1")) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        String res = solution(row, col);
        System.out.println(res);
    }

    private static String solution(boolean[] row, boolean[] col) {
        boolean turn = true;
        int i = 0;
        int j = 0;
        while (i < row.length) {
            boolean done =false;
            if (!row[i]) {
                while (j < row.length) {
                    if (!col[j]) {
                        row[i] = true;
                        col[j] = true;
                        j++;
                        done = true;
                        break;
                    }else {
                        j++;
                    }
                }
                i++;
                if(!done){
                    return (!turn)?"Ashish":"Vivek";
                }else{
                    if(turn){
                        turn =false;
                    }else {
                        turn = true;
                    }
                }
            }else {
                i++;
            }
        }
        return (!turn)?"Ashish":"Vivek";
    }
}
