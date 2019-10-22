package com;


import java.util.ArrayList;
import java.util.List;

/**

* @Description:  这个解法是leetcode上面效率非常高的一个答案

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class FindMinHeightTrees4 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        int[][] gra = new int[n][];
        for(int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if(gra[a] == null) gra[a] = edge;
            else gra[b] = edge;
        }
        int root = getRoot(gra);
        int[] node = getNode(gra, root);
        root = reverse(gra, root, node[0]);
        node = getNode(gra, root);

        //System.out.println(root + "/" + node[0] + ":" + node[1]);

        int len = node[1] / 2;
        int p = node[0];
        while(len-- != 0) p = getNext(gra, p);
        res.add(p);
        if((node[1] & 1) == 1) res.add(getNext(gra, p));

        return res;
    }

    private int reverse(int[][] gra, int root, int p) {
        int ret = p;
        int[] pre = null;
        while(p != root) {
            int next = getNext(gra, p);
            int[] temp = gra[p];
            gra[p] = pre;
            pre = temp;
            p = next;
        }
        gra[root] = pre;
        return ret;
    }

    private int[] getNode(int[][] gra, int root) {
        int n = gra.length;
        int max = 0, node = 0;
        int[] h = new int[n];
        int[] stack = new int[n];
        int size = 0;
        for(int i = 0; i < n; i++) {
            int p = i, count = 0;
            while(p != root && h[p] == 0) {
                stack[size++] = p;
                p = getNext(gra, p);
            }
            while(size != 0) {
                int temp = stack[--size];
                h[temp] = h[p] + 1;
                if(h[temp] > max) {
                    max = h[temp];
                    node = temp;
                }
                p = temp;
            }
        }
        return new int[]{node, h[node]};
    }

    private int getRoot(int[][] gra) {
        int p = 0;
        while(gra[p] != null) p = getNext(gra, p);
        return p;
    }

    private int getNext(int[][] gra, int p) {
        int[] ret = gra[p];
        return ret[0] == p ? ret[1] : ret[0];
    }
}
