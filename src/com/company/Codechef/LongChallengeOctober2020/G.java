package com.company.Codechef.LongChallengeOctober2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class G {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine().trim());
            String[] a = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < a.length; i++) {
                arr[i] = Integer.parseInt(a[i]);
            }
            int res = 0;
            int mod = 998244353;
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    PriorityQueue<Integer> queue = new PriorityQueue<>();
                    for (int k = i; k <= j; k++) {
                        queue.add(arr[k]);
                    }
                    res += (solution(queue) % mod);
                }
            }
            System.out.println(res);
        } catch (Exception e) {
            return;
        }
    }

    private static int solution(PriorityQueue<Integer> queue) {
        while (queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            int xor = xor(first, second);
            queue.add(xor);
        }
        return queue.poll();
    }

    private static int xor(int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int xor = left ^ right;
            int n = xor;
            int index = 0;
            int t = 0;
            while (n > 0) {
                if ((n & 1) == 1) {
                    index = t;
                }
                n >>= 1;
                t++;
            }
            return (int) Math.pow(2, index);
        }
    }
}
