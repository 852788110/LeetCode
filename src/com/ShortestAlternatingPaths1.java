package com;

import java.util.ArrayList;
import java.util.List;

/**

* @Description: 采用深度优先搜索

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class ShortestAlternatingPaths1 {
    /**

    * @Description: 颜色1：红色  2：蓝色    并且有可能存在平行边
     *              marked[v] 0：未访问
     *                        1：访问了红色边
     *                        2：访问了蓝色边
     *                        3：两条边均访问了
     *
     *             color[v]  0：起始点
     *                       1：红色边
     *                       2：蓝色边
     *                       3：双色边


    * @Param:

    * @return:

    * @Author: 刘洁

    * @Date:

    */

    class Digraph {
        private final int V;
        private int E;
        private List<int[]>[] adj;

        public Digraph(int V){
            this.V=V;
            this.E=0;
            this.adj=new List[V];
            for (int i=0;i<V;i++){
                adj[i]=new ArrayList<>();
            }
        }

        public void addEdge(int[] e){
            int v=e[0];
            adj[v].add(e);
        }

        public List<int[]> adj(int v){
            return adj[v];
        }

        public int getV(){
            return V;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        digraph=new Digraph(n);
        /*添加红的边*/
        for (int i=0;i<red_edges.length;i++){
            int[] temp=red_edges[i];
            int[] e=new int[3];
            e[0]=temp[0];
            e[1]=temp[1];
            e[2]=1;
            digraph.addEdge(e);
        }
        /*添加蓝色的边*/
        for (int i=0;i<blue_edges.length;i++){
            int[] temp=red_edges[i];
            int[] e=new int[3];
            e[0]=temp[0];
            e[1]=temp[1];
            e[2]=2;
            digraph.addEdge(e);
        }

        marked=new int[n];
        dist1=new int[n];
        dist2=new int[n];
        marked[0]=3;
        dfs(0,0);
        dist1=new int[n];
        dist2=new int[n];
        return new int[n];
    }
    /**

    * @Description: 深度优先遍历时，若到v的边时红色的，则遍历v的蓝色的边
     *              若到v的边是蓝色的，则遍历v的红色的边
     *

    * @Param:  v:对v点进行深度优先搜索 color：到达v点的边的颜色 cc:这条边的颜色

    * @return:

    * @Author: 刘洁

    * @Date:

    */
    private Digraph digraph;
    private int[] marked;
    private int[] dist1;
    private int[] dist2;
    private void dfs(int v,int color){
        if (marked[v]!=0){
            marked[v]=3;
        }else {
            marked[v]=color;
        }
        for (int[] edge:digraph.adj(v)){
            int w=edge[1];
            int cc=edge[2];
            if (color==0||cc!=color&&marked[w]!=cc&&marked[w]!=3){
                dfs(w,cc);
                if (cc==1){
                    dist1[w]=dist2[v]+1;
                }else {
                    dist2[w]=dist1[v]+1;
                }
            }
        }
    }

    /*private void relax(int v,int w,int[] length){
        if (length[v]+1<length[w]){
            length[w]=length[v]+1;
        }
    }*/
}
