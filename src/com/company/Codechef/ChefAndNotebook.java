package com.company.Codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class ChefAndNotebook {
    public static void main(String[] args) throws java.lang.Exception {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int  t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0 ){
                String[] w = br.readLine().trim().split(" ");
                int x  = Integer.parseInt(w[0]);
                int y = Integer.parseInt(w[1]);
                int k  = Integer.parseInt(w[2]);
                int n  = Integer.parseInt(w[3]);
                boolean res = false;

                if(res){
                    System.out.println("LuckyChef");
                }else{
                    System.out.println("UnluckyChef");
                }
            }
        }catch (Exception e){
            return;
        }
    }
}
