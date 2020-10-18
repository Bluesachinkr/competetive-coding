package com.company.TU;

public class CircularLinkedList {

    private class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;
    CircularLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void insert(int data,int pos){

    }
}
