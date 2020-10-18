package com.company.Codechef.LongChallengeOctober2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class B {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                String[] s = br.readLine().trim().split(" ");
                int[] arr = new int[s.length];
                for (int i = 0; i < s.length; i++) {
                    arr[i] = Integer.parseInt(s[i]);
                }
                int n = arr[0];
                int k = arr[1];
                int x = arr[2];
                int y = arr[3];
                int start = x;
                if(k == 1 || x == y){
                    System.out.println("YES");
                }else{
                    while (true) {
                        x = (x+k)%n;
                        if(x==y){
                            System.out.println("YES");
                            break;
                        }
                        if(x == start){
                            System.out.println("NO");
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {

        }
    }
}
