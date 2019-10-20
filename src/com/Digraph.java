package com;

import java.util.ArrayList;
import java.util.List;

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
