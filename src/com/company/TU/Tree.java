package com.company.TU;

import java.util.*;

public class Tree {
    public static void main(String[] args) {
        Tree t = new Tree();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        t.makeTree(arr);
        List<Integer> res = t.inorderTraversal(t.root);
        System.out.println(Arrays.toString(res.toArray()));
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode root;

    Tree() {
        this.root = null;
    }


    public void makeTree(int[] arr) {
      root = makeTree(root,arr,0,arr.length-1);
    }

    private TreeNode makeTree(TreeNode root, int[] arr, int low, int end) {
        if (low == end) {
            return new TreeNode(arr[low]);
        }
        if(low < end){
            int mid = low+((end-low)/2);
            root = new TreeNode(arr[mid]);
            if (mid > 0) {
                root.left = makeTree(root, arr, low, mid - 1);
            }
            if (mid < arr.length - 1) {
                root.right = makeTree(root, arr, mid + 1, end);
            }
        }
        return root;
    }

    public int lowestCommonAncestor(int a,int b){
        TreeNode node = lowestCommonAncestor(root,a,b);
        return (node == null)?-1:node.val;
    }

    private TreeNode lowestCommonAncestor(TreeNode root, int a, int b) {
        if(root == null){
            return root;
        }
        if(root.val > a && root.val > b){
            return lowestCommonAncestor(root.left,a,b);
        }
        if(root.val < a && root.val < b){
            return lowestCommonAncestor(root.right,a,b);
        }
        return root;
    }

    public int kthSmallest(TreeNode r, int k) {
        TreeNode root = r;
        if (root == null) {
            return 0;
        } else {
            Stack<TreeNode> s = new Stack<>();
            while (!s.isEmpty() || root != null) {
                while (root != null) {
                    s.add(root);
                    root = root.left;
                }
                root = s.pop();
                k--;
                if (k == 0) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return 0;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        } else {
            Stack<TreeNode> s = new Stack<>();
            while (!s.isEmpty() || root != null) {
                while (root != null) {
                    s.add(root);
                    root = root.left;
                }
                root = s.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
