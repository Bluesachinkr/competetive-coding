package com.company.Codechef.CodeAssemble;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class A {
    public static void main(String[] args) {
        try{
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0){
                int n = Integer.parseInt(br.readLine().trim());
                String[] s = br.readLine().trim().split(" ");
                int[] arr =new int[n];
                for (int i = 0; i <n ; i++) {
                    arr[i] = Integer.parseInt(s[i]);
                }
                int res = solution(arr);
                System.out.println(res);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static int solution(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> k = new HashMap<>();
        int l = -1;
        int cnt = 0;
        for (int i = 0; i <arr.length; i++) {
            if(l!=-1 && l!=arr[i]){
                if(!map.containsKey(cnt)){
                    map.put(cnt,map.getOrDefault(cnt,0)+1);
                    k.put(cnt,l);
                    l = arr[i];
                    cnt = 1;
                }else {
                    l = arr[i];
                    cnt = 1;
                }
            }else{
                if(l== -1){
                    l = arr[i];
                    cnt = 1;
                }else{
                    cnt++;
                }
            }
        }
        int res = -1;
        int c = 0;
        for (Map.Entry<Integer,Integer> m : map.entrySet()){
            if(m.getValue() > c){
                res = m.getKey();
                c = m.getValue();
            }
        }
        return k.get(res);
    }
}
