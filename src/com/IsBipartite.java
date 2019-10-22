package com;

public class IsBipartite {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable=true;
    private int[][] graph;
    public boolean isBipartite(int[][] graph) {
        marked=new boolean[graph.length];
        color=new boolean[graph.length];
        this.graph=graph;
        for (int v=0;v<graph.length;v++){
            if (!marked[v]){
                dfs(v);
            }
        }
        return isTwoColorable;
    }

    private void dfs(int v){
        marked[v]=true;
        if (isTwoColorable==false){
            return;
        }
        for (int i=0;i<graph[v].length;i++){
            int w=graph[v][i];
            if (!marked[w]){
                color[w]=!color[v];
                dfs(w);
            }else if (color[w]==color[v]){
                isTwoColorable=false;
            }
        }
    }
}
