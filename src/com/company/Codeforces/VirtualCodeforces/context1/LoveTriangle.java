package com.company.Codeforces.VirtualCodeforces.context1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LoveTriangle {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int k = 1;
            while (true){
                if(!isPrime(n*k+1)){
                    System.out.println(k);
                    break;
                }
                k++;
            }
        } catch (Exception e) {
            return;
        }
    }

    static boolean isPrime(int n){
        for (int i = 2; i <n ; i++) {
            if((n%i) == 0){
                return false;
            }
        }
        return true;
    }
}
