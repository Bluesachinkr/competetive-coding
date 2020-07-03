package com.company.Codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Carvans {
    public static void main(String[] args) throws java.lang.Exception {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0){
                int n = Integer.parseInt(br.readLine().trim());
                String[] w = br.readLine().trim().split(" ");
                int[] a=new int[w.length];
                for (int i = 0; i <w.length ; i++) {
                    a[i] = Integer.parseInt(w[i]);
                }
                int res = solution(a);
                System.out.println(res);
            }
        }catch (Exception e){
            return;
        }
    }

    private static int solution(int[] a) {
        if(a.length < 2){
            return a.length;
        }else{
            int res = 1;
            int prev = a[0];
            for (int i = 1; i <a.length ; i++) {
                if(a[i] <= prev){
                    prev = a[i];
                    res++;
                }
            }
            return res;
        }
    }
}
