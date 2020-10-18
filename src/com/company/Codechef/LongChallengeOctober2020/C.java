package com.company.Codechef.LongChallengeOctober2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class C {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                if (powerOfTwo(n)) {
                    System.out.println(-1);
                } else if (n == 1) {
                    System.out.println(1);
                }else if(n==3) {
                    System.out.println(1+" "+3+" "+2);
                }else if (n == 5) {
                    System.out.println(2 + " " + 3 + " " + 1 + " " + 5 + " " + 4);
                } else {
                    int  k  =6;

                        System.out.print(2 + " " + 3 + " " + 1 + " " + 5 + " " + 4 + " ");

                    while (k <= n) {
                        if (powerOfTwo(k)) {
                            System.out.print(k + 1 + " " + k + " ");
                            k += 2;
                        } else {
                            System.out.print(k + " ");
                            k++;
                        }
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean powerOfTwo(int num) {
        return num!=0 && ((num & (num-1)) == 0);
    }
}
