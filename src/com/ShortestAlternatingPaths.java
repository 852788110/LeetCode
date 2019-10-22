package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**

* @Description: 这道题采用广度优先搜索
 *              这个方法解决不了环，平行边

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class ShortestAlternatingPaths {
    class Digraph {
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

    private Digraph digraph;
    int[][] color;
    private boolean[] marked;
    private Queue<Integer> queue;
    private int[] dist;
    private int[] preColor;
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        digraph=new Digraph(n);
        /*1:红色  2:蓝色 3:红色蓝色都有*/
        color=new int[n][n];
        /*构造图*/
            /*构造红色边*/
        for (int i=0;i<red_edges.length;i++){
            int v=red_edges[i][0];
            int w=red_edges[i][1];
            digraph.addEdge(v,w);
            color[v][w]=1;
        }
            /*构造蓝色边*/
        for (int i=0;i<blue_edges.length;i++){
            int v=blue_edges[i][0];
            int w=blue_edges[i][1];
            digraph.addEdge(v,w);
            if (color[v][w]==1){
                color[v][w]=3;
            }else {
                color[v][w] = 2;
            }
        }
        marked=new boolean[n];
        queue=new LinkedList<>();
        dist=new int[n];
        /*记录0到v这条边的颜色*/
        preColor=new int[n];
        BFS(0);
        for (int i=0;i<n;i++){
            if (!marked[i]){
                dist[i]=-1;
            }
        }
        return dist;
    }

    private void BFS(int k){
        queue.add(k);
        while (!queue.isEmpty()){
            int v=queue.poll();
            marked[v]=true;
            for (int w:digraph.adj(v)){
                if (!marked[w]){
                    /*首先检查颜色是否符合*/
                    /*如果v是第一个顶点*/
                    preColor[w]=color[v][w];
                    if (preColor[w]!=3&&preColor[v]!=3&&preColor[w]==preColor[v]||dist[v]==-1){
                        dist[w]=-1;
                    }else{
                        dist[w]=dist[v]+1;
                    }
                    queue.add(w);
                }
            }
        }
    }
}
