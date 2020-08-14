package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RelativePrime {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }

    private Node deleteNode(int data,Node head){
        if(head == null) {
            return null;
        }else{
            if(head.val == data){
                if(head.left == null && head.right == null){
                     return null;
                }else if(head.right == null && head.left !=null){
                    return head.left;
                }else if(head.right!=null && head.left ==null){
                    return head.right;
                }else{
                    int temp = right(head.right);
                    Node node =new Node(temp);
                    node.left = head.left;
                    node.right = deleteNode(temp,head.right);
                    return node;
                }
            }else{
                if(head.val > data){
                    head.right = deleteNode(data,head.right);
                }else{
                    head.left = deleteNode(data,head.left);
                }
            }
        }
        return head;
    }

    private int right(Node right) {
        if (right.right == null){
            return right.val;
        }
        return right(right.right);
    }

    private Node addNode(Node head,int data){
        if(head == null){
            return new Node(data);
        }else{
            if(data  < head.val){
                head.left = addNode(head.left,data);
            }else{
                head.right = addNode(head.right,data);
            }
        }
        return head;
    }

    private int height(Node head){
        if(head == null){
            return 0;
        }
        return 1+Math.max(height(head.left),height(head.right));
    }

    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t =Integer.parseInt(br.readLine().trim());
            while (t-- > 0){
                int n = Integer.parseInt(br.readLine().trim());
                String[] w = br.readLine().split(" ");
                int[] a=new int[n];

            }
        }catch (Exception e){

        }finally {

        }
    }
}
