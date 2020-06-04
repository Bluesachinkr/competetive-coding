package com.company.Codechef;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class EnormousIO {
    public static void main(String[] args) throws java.lang.Exception {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String[] w = br.readLine().split(" ");
            int n =Integer.parseInt(w[0]);
            int k = Integer.parseInt(w[1]);
            int res = 0;
            for (int i = 0; i <n ; i++) {
                int r = Integer.parseInt(br.readLine().trim());
                if(r%k == 0){
                    res++;
                }
            }
            System.out.println(res);
        }catch (Exception e){
        }finally {
        }
    }
}
