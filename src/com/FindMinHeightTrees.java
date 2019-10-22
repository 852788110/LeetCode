package com;

import java.util.*;

public class FindMinHeightTrees {
     class Graph {
        private final int V;
        private int E;
        private List<Integer>[] adj;
        public Graph(int V){
            this.V=V;
            this.E=0;
            this.adj=new List[V];
            for (int v=0;v<V;v++){
                adj[v]=new ArrayList<>();
            }
        }

        public int V(){
            return V;
        }

        public int E(){
            return E;
        }

        public void addEdge(int v,int w){
            adj[v].add(w);
            adj[w].add(v);
            E++;
        }

        public List<Integer> adj(int v){
            return this.adj[v];
        }
    }

    private Graph graph;
    private Queue<Integer> queue;
    private boolean[] marked;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        graph=new Graph(n);
        for (int i=0;i<edges.length;i++){
             int v=edges[i][0];
             int w=edges[i][1];
             graph.addEdge(v,w);
         }

        int[] ans=new int[n];
        int minHeight=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            ans[i]=bfs(i);
            if (ans[i]<minHeight){
                minHeight=ans[i];
            }
        }

        List<Integer> res=new ArrayList<>();
        for (int i=0;i<n;i++){
            if (ans[i]==minHeight){
                res.add(i)
;            }
        }
        return res;
    }

    private int bfs(int k){
        queue=new LinkedList<>();
        marked=new boolean[graph.V()];
        queue.add(k);
        int pre=1,cur=0,height=0;
        while(!queue.isEmpty()){
            int v=queue.poll();
            marked[v]=true;
            pre--;
            for (int w:graph.adj(v)){
                if (!marked[w]){
                    queue.add(w);
                    cur++;
                }
            }
            if (pre==0){
                pre=cur;
                cur=0;
                height++;
            }
        }
        return height;
    }
}
