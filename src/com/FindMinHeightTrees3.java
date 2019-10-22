package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 

* @Description: 这个方法有点问题，太慢了

* @Param:  

* @return:  

* @Author: 刘洁

* @Date:  

*/ 

public class FindMinHeightTrees3 {
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

    private boolean[] unvalid;
    private boolean[] marked;
    private Queue<Integer> queue;
    private Graph graph;
    private int times;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        graph = new Graph(n);
        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int w = edges[i][1];
            graph.addEdge(v, w);
        }
        unvalid=new boolean[graph.V()];
        List<Integer> ans=new ArrayList<>();
        times=graph.V();

        while(times>0){
            if (times<=2){
                for (int i=0;i<unvalid.length;i++){
                    if (unvalid[i]==false){
                        ans.add(i);
                    }
                }
                return ans;
            }
            /*if (unvalid[v]!=true){
                bfs(v);
            }*/
            int i=0;
            while (i<n){
                if (unvalid[i]!=true){
                    break;
                }
                i++;
            }
            bfs(i);
        }
        return ans;
    }

    private void bfs(int k){
        List<Integer> del=new ArrayList<>();
        marked=new boolean[graph.V()];
        queue=new LinkedList<>();
        queue.add(k);
        while(!queue.isEmpty()){
            int v=queue.poll();
            marked[v]=true;
            int time=0;
            for (int w:graph.adj(v)){
                if (unvalid[w]!=true){
                    time++;
                    if (!marked[w]){
                        queue.add(w);
                    }
                }
            }
            if (time<=1){
                del.add(v);
                times--;
            }
        }

        for (int t:del){
            unvalid[t]=true;
        }
    }
}
