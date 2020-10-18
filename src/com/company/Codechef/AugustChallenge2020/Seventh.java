package com.company.Codechef.AugustChallenge2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Seventh {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                String[] w = br.readLine().trim().split(" ");
                int n = Integer.parseInt(w[0]);
                int c = Integer.parseInt(w[1]);
                int k = Integer.parseInt(w[2]);
                int[][] lines = new int[n][3];
                HashMap<Integer, Integer> slopes = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    String[] s1 = br.readLine().trim().split(" ");
                    lines[i][0] = Integer.parseInt(s1[0]);
                    lines[i][1] = Integer.parseInt(s1[1]);
                    lines[i][2] = Integer.parseInt(s1[2]);
                    slopes.put(lines[i][0], slopes.getOrDefault(lines[i][0], 0) + 1);
                }
                int[] V = new int[c];
                String[] s2 = br.readLine().trim().split(" ");
                for (int i = 0; i < s2.length; i++) {
                    V[i] = Integer.parseInt(s2[i]);
                }
                int res = result(lines,V,k,0,0,new HashMap<>(),0);
                System.out.println(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int result(int[][] lines, int[] v, int k, int index,int length,HashMap<Integer,Boolean> map,int currentcost) {
       if(length == lines.length){
           return totalTriangles(lines,map);
       }else{
           int res = Integer.MAX_VALUE;
           int color = lines[index][2];
           int cost = v[color-1];
           int ts = -1;
           if(currentcost+cost > k){
               map.put(index,false);
               ts = result(lines,v,k,index+1,length+1,map,currentcost);
           }else{
               map.put(index,false);
               int temp = result(lines,v,k,index+1,length+1,map,currentcost);
               map.put(index,true);
               int r = result(lines,v,k,index+1,length+1,map,currentcost+cost);
               ts = Math.min(temp,r);
           }
           if(ts < res){
               return ts;
           }else{
               return res;
           }
        }
    }

    private static int totalTriangles(int[][] arr, HashMap<Integer, Boolean> isAdd) {
        HashMap<Integer, HashMap<Integer, Integer>> l = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (isAdd == null || !isAdd.get(i)) {
                int color = arr[i][2];
                int m = arr[i][0];
                HashMap<Integer, Integer> map;
                if (l.containsKey(color)) {
                    map = l.get(color);
                } else {
                    map = new HashMap<>();
                }
                map.put(m, map.getOrDefault(m, 0) + 1);
                l.put(color, map);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, HashMap<Integer, Integer>> e : l.entrySet()) {
            HashMap<Integer, Integer> s = e.getValue();
            int s1 = 0;
            for (Map.Entry<Integer, Integer> es : s.entrySet()) {
                s1 += es.getValue();
            }

            int s2 = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            for (Map.Entry<Integer, Integer> es : s.entrySet()) {
                int t = es.getValue() * (s1 - es.getValue());
                temp.add(t);
                s2 += t;
            }
            s2 /= 2;
            int s3 = 0;
            int index = 0;
            for (Map.Entry<Integer, Integer> es : s.entrySet()) {
                s3 += es.getValue() * (s2 - temp.get(index));
                index++;
            }
            res+=(s3/3);
        }
        return res;
    }
}
