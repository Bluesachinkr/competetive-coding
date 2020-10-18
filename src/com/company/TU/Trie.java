package com.company.TU;

import java.util.ArrayList;
import java.util.Vector;

public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

    class Node{
        ArrayList<Node> children;
        boolean isEnd;
        Node(){
            children = new ArrayList<>(26);
            for(int i=0;i<26;i++){
                children.add(null);
            }
            this.isEnd = false;
        }
    }
    private Node root;
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        root = insert(root,word);
    }

    private Node insert(Node root,String word){
        Node temp = root;
        for(int i =0;i<word.length();i++){
            Character ch = word.charAt(i);
            int index = ch-'a';
            if(temp.children.get(index) == null){
                temp.children.set(index,new Node());
            }
            temp = temp.children.get(index);
        }
        temp.isEnd = true;
        return root;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node t = root;
        for(int i=0;i<word.length();i++){
            Character c = word.charAt(i);
            int index = c-'a';
            if(t.children.get(index) == null){
                return false;
            }
            if(i == word.length()-1 && !t.children.get(index).isEnd){
                return false;
            }
            t = t.children.get(index);
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        Node t = root;
        for(int i=0;i<word.length();i++){
            Character c = word.charAt(i);
            int index = c-'a';
            if(t.children.get(index) == null){
                return false;
            }
            if(i == word.length()-1 && t.children.get(index).isEnd){
                return false;
            }
            t = t.children.get(index);
        }
        return true;
    }
}
