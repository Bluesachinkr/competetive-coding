package com.company.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Codeforces_1327A {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            String[] w = br.readLine().split(" ");
            int n = Integer.parseInt(w[0]);
            int k = Integer.parseInt(w[1]);
            int res = solution(n,k);
        }
    }

    private static int solution(int n, int k) {
        int res = 0;
        return res;
    }
}
