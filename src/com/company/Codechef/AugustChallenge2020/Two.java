package com.company.Codechef.AugustChallenge2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Two {
    public static void main(String[] args){
        try {
           new Solver();
        } catch (Exception e) {
            return;
        }
    }

    static class Solver {
        Solver() throws Exception {
            textCase();
        }

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        private void textCase() throws java.lang.Exception {
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                String[] w = br.readLine().trim().split(" ");
                int n = Integer.parseInt(w[0]);
                int k = Integer.parseInt(w[1]);
                String[] w1 = br.readLine().trim().split(" ");
                int[] a = new int[n];
                for (int i = 0; i < w1.length; i++) {
                    a[i] = Integer.parseInt(w1[i]);
                }
                long res = solution(k, a);
                System.out.println(res);
            }
        }

        private long solution(int k, int[] a) {
            Arrays.sort(a);
            long res = -1;
            long val = Integer.MAX_VALUE;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == k) {
                    return 0;
                } else if (a[i] > k) {
                    break;
                } else {
                    if (k % a[i] == 0) {
                        int r = k / a[i];
                        if (r < val) {
                            val = r;
                            res = a[i];
                        }
                    }
                }
            }
            return res;
        }
    }
}
