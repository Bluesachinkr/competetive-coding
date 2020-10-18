package com.company.TU;

import java.util.Vector;

public class SuffixTree {
    class Node {
        Vector<Node> children;
        Node suffixLink;
        int start;
        int end;
        int suffixIndex;

        Node(int start, int end, int suffixIndex) {
            this.children = new Vector<>();
            this.suffixLink = null;
            this.start = start;
            this.end = end;
            this.suffixIndex = suffixIndex;
        }
    }

    private Node root;

    private Node activeNode;
    private int activeLength;
    private int leafEnd;
    private int activeEdge;
    private int remainingSuffixCount;

    private Node lastNode;

    public SuffixTree() {
        this.root = null;
        this.activeEdge = -1;
        this.activeLength = 0;
        this.activeNode = null;
        this.remainingSuffixCount = 0;
        this.lastNode = null;
        this.leafEnd = -1;
    }

    public static void main(String[] args) {
        SuffixTree tree = new SuffixTree();
        String str = "abcabxabcd";
        tree.buildSuffixTree(str);
    }

    private void buildSuffixTree(String str) {
        root = new Node(-1, -1, -1);

        this.activeNode = root;
        for (int i = 0; i < str.length(); i++) {
            extendTree(i);
        }
    }

    private void extendTree(int pos) {
        this.leafEnd = pos;


    }
}
