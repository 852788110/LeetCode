package com;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**

* @Description: 尝试一种新的方法，对广度搜先搜索进行优化
 *              这种方法无法解决

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class FindMinHeightTrees2 {
    class Graph {
        private final int V;
        private int E;
        private List<Integer>[] adj;

        public Graph(int V) {
            this.V = V;
            this.E = 0;
            this.adj = new List[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new ArrayList<>();
            }
        }

        public int V() {
            return V;
        }

        public int E() {
            return E;
        }

        public void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
            E++;
        }

        public List<Integer> adj(int v) {
            return this.adj[v];
        }
    }

    private Graph graph;
    private Queue<Integer> queue;
    private boolean[] marked;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        graph = new Graph(n);
        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int w = edges[i][1];
            graph.addEdge(v, w);
        }
        int[][] dist1=bfs(0);
        int[][] dist2=bfs(n-1);
        int[] ans=new int[n];
        int minHeight=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            int sum=0;
            for (int j=0;j<n;j++){
                if (dist1[i][j] == 0) {
                    sum=dist2[i][j];
                }else {
                    sum=dist1[i][j];
                }
                if (sum>ans[i]){
                    ans[i]=sum;
                }
            }
            if (minHeight>ans[i]){
                minHeight=ans[i];
            }
        }
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<n;i++){
            if (ans[i]==minHeight){
                res.add(i);
            }
        }
        return res;
    }


    private int[][] bfs(int k) {
        int n = graph.V();
        int[][] dist = new int[n][n];
        marked = new boolean[n];
        queue = new LinkedList<>();
        queue.add(k);
        int[] parent=new int[n];
        for (int i=0;i<n;i++){
            parent[i]=i;
        }
        while (!queue.isEmpty()) {
            int v = queue.poll();
            marked[v] = true;
            if (parent[v] != v) {
                for (int i = 0; i < dist.length; i++) {
                    if (dist[parent[v]][i] != 0 && i != v) {
                        dist[v][i] = dist[parent[v]][i] + 1;
                    }
                }
            }
                for (int w : graph.adj(v)) {
                    if (!marked[w]) {
                        queue.add(w);
                        dist[w][v] = 1;
                        dist[v][w] = 1;
                        parent[w]=v;
                    }
                }
            }
        return dist;
    }
}

