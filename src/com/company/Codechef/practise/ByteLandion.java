package com.company.Codechef.practise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

class ByteLandion {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                long n = scanner.nextLong();
                long res = solution(n);
                System.out.println(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static long solution(long n) {
        if (n>=12) {
            long two = n / 2;
            long three = n / 3;
            long four = n / 4;
            long sum = solution(two) + solution(three) + solution(four);
            if (sum < n) {
                return n;
            }else{
                return sum;
            }
        } else {
            return n;
        }

    }
}
