package com.company.Codechef.practise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.IllegalCharsetNameException;
import java.util.*;

class CSUB {
    public static void main (String[] args) throws java.lang.Exception
    {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-- > 0){
                String[] w = br.readLine().split(" ");
                long low = 1;
                int n = Integer.parseInt(w[0]);
                int k = Integer.parseInt(w[1]);
                if(n == k){
                    System.out.println(n+1);
                }else {
                    long high = n * k;
                    while (low <= high) {
                        long mid = low + ((high - low) / 2);
                        long div = mid / n;
                        long dif = mid - div;
                        if (dif == k) {
                            System.out.println(mid);
                            break;
                        } else if (dif < k) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }// your code goes here
    }

}
