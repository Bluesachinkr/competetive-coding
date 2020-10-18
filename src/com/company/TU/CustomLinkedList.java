package com.company.TU;

public class CustomLinkedList {
    public static void main(String[] args) {
        Node head = null;
        head = insert(head, 101);
        head = insert(head, 8);
        head = insert(head, 90);
        head = insert(head, 32);
        head = insert(head, 89);
        head = insert(head, 17);
        head  = insert(head, 21);
        print(head);
        head = mergeSort(head);
        print(head);
    }

    private static void print(Node head) {
        Node node = head;
        while (node != null) {
            if (node.next == null) {
                System.out.println(node.data);
            } else {
                System.out.print(node.data + "->");
            }
            node = node.next;
        }
    }

    private static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node middleNext = middle.next;

        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(middleNext);

        return sortedMerge(left, right);
    }

    private static Node sortedMerge(Node left, Node right) {
        Node res = null;
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.data > right.data) {
            res = right;
            res.next = sortedMerge(left, right.next);
        } else {
            res = left;
            res.next = sortedMerge(left.next, right);
        }
        return res;
    }

    private static Node getMiddle(Node head) {
        Node f = head;
        Node s = head;
        while (f.next!=null && f.next.next!=null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    private static Node insert(Node head, int data) {
        if (head != null) {
            Node t = head;
            while (t != null) {
                if (t.next == null) {
                    t.next = new Node(data);
                    break;
                }
                t = t.next;
            }
        }else{
            head = new Node(data);
        }
        return head;
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
