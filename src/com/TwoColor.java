package com;

public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable=true;
    public TwoColor(Graph G){
        marked=new boolean[G.V()];
        color=new boolean[G.V()];
    }

    private void dfs(Graph G,int v){
        marked[v]=true;
        for (int w:G.adj(v)){
            if (isTwoColorable!=true){
                return;
            }
            if (!marked[w]){
                color[w]=!color[v];
                dfs(G,w);
            }else if (color[w]==color[v]){
                isTwoColorable=false;
            }
        }
    }
}
