package com.company.Codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] w = br.readLine().split(" ");
            int cash = Integer.parseInt(w[0]);
            double balance = Double.parseDouble(w[1]);
            if ((cash+0.50) <=balance && cash % 5 == 0) {
                balance = balance - cash - 0.50;
            }
            System.out.printf("%.2f", balance);

        } catch (Exception e) {
        } finally {
        }
    }

    static class Code {
        public static void main(String[] args) throws Exception {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String[] w = br.readLine().split(" ");
                int n = Integer.parseInt(w[0]);
                int k = Integer.parseInt(w[1]);
                int a[] = new int[k];
                for (int i = 0; i < a.length; i++) {
                    a[i] = Integer.parseInt(br.readLine().trim());
                }
                long res = solution(a, n);
                System.out.println(res);
                /*String s=br.readLine().trim();
                stringSub(s);*/
            } catch (Exception e) {
            }
        }

        static int setbits(int n) {
            int cnt = 0;
            while (n > 0) {
                cnt += n & 1;
                n = n >> 1;
            }
            return cnt;
        }

        private static long solution(int[] a, int n) {
            long res = 0;
            int size = (1 << a.length) - 1;
            for (int i = 0; i < size; i++) {
                long denom = 1;
                int setBITS = setbits(i);
                for (int j = 0; j < a.length; j++) {
                    if ((i & (1 << j)) == 0) {
                        denom = denom * a[j];
                    }
                }
                if ((setBITS & 1) == 0) {
                    res += ((n - 1) / denom) + 1;
                } else {
                    res -= ((n - 1) / denom) + 1;
                }
            }
            return res;
        }

        static void stringSub(String s) {
            int size = (1 << s.length()) - 1;
            for (int i = 0; i <size; i++) {
                for (int j = 0; j < s.length(); j++) {
                    if((i & (1<<j)) == 0){
                        System.out.print(s.charAt(j));
                    }
                }
                System.out.println();
            }
        }
    }
}
