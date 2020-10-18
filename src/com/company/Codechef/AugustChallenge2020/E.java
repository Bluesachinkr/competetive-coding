package com.company.Codechef.AugustChallenge2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class E {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                String[] w = br.readLine().split(" ");
                int n = Integer.parseInt(w[0]);
                int k = Integer.parseInt(w[1]);
                int[] arr = new int[n];
                String w1[] = br.readLine().trim().split(" ");
                for (int i = 0; i < w1.length; i++) {
                    arr[i] = Integer.parseInt(w1[i]);
                }
                long res = solution(arr,k);
                System.out.println(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static long solution(int[] arr, int k) {
        int[][] conflict = new int[arr.length + 1][arr.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.clear();
            for (int j = i; j < arr.length; j++) {
                if (j == 0) {
                    conflict[i][j] = 0;
                } else {
                    conflict[i][j] = conflict[i][j - 1];
                }
                if (map.containsKey(arr[j])) {
                    if (map.get(arr[j]) == 1) {
                        conflict[i][j]++;
                    }
                    conflict[i][j]++;

                }
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
        }

        int totalLength = 100;
        long res = Integer.MAX_VALUE;
        long[][] dp = new long[totalLength+1][arr.length + 1];
        for (int i = 1; i < arr.length + 1; i++) {
            dp[1][i] = conflict[0][i - 1];
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 2; j <= arr.length; j++) {
                long currentsol = Integer.MAX_VALUE;
                for (int l = 1; l < j; l++) {
                    currentsol = Math.min(currentsol, dp[i - 1][l] + conflict[l][j - 1]);
                }
                dp[i][j] = currentsol;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            res = Math.min(res, (i * k) + dp[i][arr.length]);
        }
        return res;
    }
}
