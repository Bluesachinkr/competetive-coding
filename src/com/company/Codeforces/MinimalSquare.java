package com.company.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimalSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] w = br.readLine().split(" ");
            int a = Integer.parseInt(w[0]);
            int b = Integer.parseInt(w[1]);
            if(a>b){
                if(a > 2*b){
                    System.out.println(a*a);
                }else{
                    System.out.println(b*b*4);
                }
            }else{
                if(b > 2*a){
                    System.out.println(b*b);
                }else{
                    System.out.println(a*a*4);
                }
            }
        }
    }
}
