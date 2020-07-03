package com.company.TU;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Practise {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            //Carmer's Rule
            double a1 = 3;
            double b1 = 4;
            double c1 = -10;
            double a2 = 2;
            double b2 = -2;
            double c2 = -2;

            double denominator = den(a1,b1,a2,b2);
            if(denominator == 0){
                System.out.println("Infinite or no solu");
            }else{
                double numx = den(b1,c1,b2,c2);
                double numy = den(a1,c1,a2,c2);
                double x = -(numx/denominator);
                double y = -(numy/denominator);
                System.out.println(x +" "+y);
            }
        } catch (Exception e) {
            return;
        }
    }

    private static double  den(double a,double b,double c,double d){
        return (a*d)-(c*b);
    }
}

