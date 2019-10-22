package com;

import java.util.ArrayList;
import java.util.List;

public class Graph {
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
