package com;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

* @Description: 使用并查集

* @Param:  

* @return:  

* @Author: 刘洁

* @Date:  

*/ 

public class FindRedundantConnection {
    private int[] parent;
    private int[] rank;
    private int[] result;

    public int[] findRedundantConnection(int[][] edges) {
        int length = edges.length;
        parent = new int[length + 1];
        rank = new int[length + 1];
        for (int i = 0; i < length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < edges.length; i++) {
            union(edges[i][0], edges[i][1]);
        }
        return result;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            result = new int[]{p, q};
        }
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[qRoot] += 1;
        }

    }

    private int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
