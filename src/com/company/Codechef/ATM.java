package com.company.Codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] w = br.readLine().split(" ");
            int cash = Integer.parseInt(w[0]);
            double balance = Double.parseDouble(w[1]);
            if ((cash+0.50) <=balance && cash % 5 == 0) {
                balance = balance - cash - 0.50;
            }
            System.out.printf("%.2f", balance);

        } catch (Exception e) {
        } finally {
        }
    }
}
