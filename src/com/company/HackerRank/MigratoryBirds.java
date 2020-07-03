package com.company.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class MigratoryBirds {
    public static void main(String[] args) {
        int[] a ={1,4,4,4,5,3};
        List<Integer> l=new ArrayList<>();
        for (int i = 0; i <a.length ; i++) {
            l.add(i,a[i]);
        }
        int res = migratoryBirds(l);
        System.out.println(res);
    }

    static int migratoryBirds(List<Integer> arr) {
        int[] fre = new int[6];
        for (int i = 0; i < arr.size(); i++) {
            int r = arr.get(i);
            fre[r]++;
        }
        int res = 0;
        int max = Integer.MIN_VALUE;
        for(int i=1;i<fre.length;i++){
            if(fre[i] > max){
                res = i;
                max = fre[i];
            }
        }
        return res;
    }
}
