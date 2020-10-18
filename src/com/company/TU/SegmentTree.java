package com.company.TU;

public class SegmentTree {

    public static void main(String[] args) {
        int arr[] = {0,1,2,3};

        SegmentTree tree = new SegmentTree(arr);
        System.out.println(tree.getSum(1, 3));
        tree.updateValue(arr,2,12);
        System.out.println(tree.getSum(1,3));
    }

    private int st[];
    private int initialArraySize;

    SegmentTree(int arr[]) {
        this.initialArraySize = arr.length;
        int powerIndex = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));
        //calculating size
        int size = 2 * ((int) Math.pow(2, powerIndex));
        //making segment tree
        this.st = new int[size];

        constructSegementTree(arr, 0, arr.length - 1, 0);
    }

    private int constructSegementTree(int[] arr, int low, int end, int index) {
        if (low == end) {
            st[index] = arr[low];
            return st[index];
        }

        int mid = low + (end - low) / 2;

        st[index] = constructSegementTree(arr, low, mid, 2 * index + 1) +
                constructSegementTree(arr, mid + 1, end, 2 * index + 2);
        return st[index];
    }

    public int getSum(int l, int r) {
        if (l < 0 || r > initialArraySize || l > r) {
            return -1;
        }
        return getSumUtil(0, initialArraySize - 1, l, r, 0);
    }

    private int getSumUtil(int ss, int se, int l, int r, int index) {
        if (l <= ss && r >= se) {
            return st[index];
        }

        if (l > se || r < ss) {
            return 0;
        }

        int mid = ss + (se - ss) / 2;
        return getSumUtil(ss, mid, l, r, 2 * index + 1) +
                getSumUtil(mid + 1, se, l, r, 2 * index + 2);
    }

    public void updateValue(int[] arr, int pos, int val) {
        if (pos >= 0 && pos < arr.length) {
            int diff = val - arr[pos];
            arr[pos] = val;
            updateValueUtil(0, initialArraySize, pos, diff, 0);
        }
    }

    private void updateValueUtil(int start, int end, int pos, int diff, int index) {
        if (pos > end || pos < start) {
            return;
        }
        st[index] += diff;
        if (start != end) {
            int mid = start + (end - start) / 2;
            updateValueUtil(start, mid, pos, diff, 2 * index + 1);
            updateValueUtil(mid + 1, end, pos, diff, 2 * index + 2);
        }
    }
}
