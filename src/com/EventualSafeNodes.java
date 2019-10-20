package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 

* @Description: 这道题主要是判断哪些结点构成了环 

* @Param:  

* @return:  

* @Author: 刘洁

* @Date:  

*/ 

public class EventualSafeNodes {

    public class Digraph {
        private final int V;
        private int E;
        private List<Integer>[] adj;

        public Digraph(int V){
            this.V=V;
            this.E=0;
            this.adj=new List[V];
            for (int i=0;i<V;i++){
                adj[i]=new ArrayList<>();
            }
        }

        public void addEdge(int v,int w){
            adj[v].add(w);
            E++;
        }

        public List<Integer> adj(int v){
            return adj[v];
        }

        public int getV(){
            return V;
        }
    }

    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] loop;
    private boolean hasCycle;
    private boolean[] onStack;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        /*首先构造图*/
        Digraph G=new Digraph(graph.length);
        for (int i=0;i<graph.length;i++){
            for (int j=0;j<graph[i].length;j++){
                G.addEdge(i,graph[i][j]);
            }
        }

        hasCycle=false;
        onStack=new boolean[G.getV()];

        edgeTo=new int[G.getV()];
        loop=new boolean[G.getV()];
        for (int i=0;i<G.getV();i++){
            marked=new boolean[G.getV()];
            onStack=new boolean[G.getV()];
            if (loop[i]==false){
                dfs(G,i);
            }
        }

        List<Integer> ans=new ArrayList<>();
        for (int i=0;i<G.getV();i++){
            hasCycle=false;
            if (loop[i]==false){
                ans.add(i);
            }
        }
        return ans;
    }

    private void dfs(Digraph G,int v){
        onStack[v]=true;
        marked[v]=true;
        for (int w:G.adj(v)){
            if (hasCycle){
                return;
            }else if (!marked[w]){
                edgeTo[w]=v;
                dfs(G,w);
            }else if (onStack[w]) {
                for (int i=0;i<G.getV();i++){
                    if (onStack[i]==true){
                        loop[i]=true;
                    }
                }
                return;
            }
        }
        onStack[v]=false;
    }
}
