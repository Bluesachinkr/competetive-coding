package com.company.Codechef.JuneLuncTime2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class A {
    public static void main(String[] args) throws java.lang.Exception {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int  t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0){
                String[] w = br.readLine().trim().split(" ");
                int s = Integer.parseInt(w[0]);
                int n = Integer.parseInt(w[1]);
                int res = solution(s,n);
                System.out.println(res);
            }

        }catch (Exception e){
            return;
        }
    }

    private static int solution(int s, int n) {
        int res =0;
        if(s==1){
            return 1;
        }
        if((s&1)==1){
            s--;
            res++;
        }
        if(s >=n){
            res+=s/n;
            s%=n;
            if(s!=0){
                res++;
            }
        }else{
           res++;
        }
        return res;
    }
}
