package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TomAndJerry {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                long ts = Long.parseLong(br.readLine().trim());
                long res = solution(ts);
                System.out.println(res);
            }
        } catch (Exception e) {
        } finally {
        }
    }

    private static long solution(long ts) {
        if (ts % 2 == 0) {
            long res = 0;
            long start = p(ts)/2;
            long d = ts/start;
            d/=2;
            return d;
        } else {
            return ts / 2;
        }
    }

    static long p(long a) {
        long p = 2;
        while (a % p == 0) {
            p = p * 2;
        }
        return p;
    }
}
