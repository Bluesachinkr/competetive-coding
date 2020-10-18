package com.company.TU;

public class DoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insert(3, 1);
        linkedList.insert(6, 8);
        linkedList.insert(23, 1);
        linkedList.insert(4, 4);
        linkedList.insert(21, 1);
        linkedList.delete(23);
        linkedList.insert(55,2);
        linkedList.insert(90,2);
        System.out.println(linkedList.toString());
        linkedList.deleteAtFront();
        System.out.println(linkedList.toString());
    }

    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private int size;

    DoublyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("");
        Node node = head;
        while (node != null) {
            builder.append(node.data + " ");
            node = node.next;
        }
        return builder.toString();
    }

    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            this.head = newNode;
        }
        size++;
    }

    public void insertAtEnd(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node temp = this.head;
            while (temp != null) {
                if (temp.next == null) {
                    temp.next = node;
                    node.prev = temp;
                    break;
                }
                temp = temp.next;
            }
        }
        size++;
    }

    public void insert(int data, int position) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            if (position == 1) {
                insertAtFront(data);
            } else if (position > size) {
                insertAtEnd(data);
            } else {
                Node temp = this.head;
                while (temp != null && position > 0) {
                    position--;
                    temp = temp.next;
                }
                temp.prev.next = node;
                node.prev = temp.prev;
                temp.prev = node;
                node.next = temp;
                size++;
            }
        }
    }

    public void deleteAtFront() {
        if (head != null) {
            this.head.next.prev = null;
            this.head = head.next;
        }
    }

    public void delete(int data) {
        if (size == 0 || head == null) {
            return;
        } else {
            if (head.data == data) {
                deleteAtFront();
            } else {
                Node temp = this.head;
                while (temp != null) {
                    if (temp.data == data) {
                        if (temp.next != null) {
                            temp.prev.next = temp.next;
                            temp.next.prev = temp.prev;
                        } else {
                            temp.prev.next = null;
                        }
                        break;
                    }
                    temp = temp.next;
                }
            }
        }
    }
}
