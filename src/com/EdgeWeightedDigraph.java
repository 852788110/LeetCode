package com;

import java.util.ArrayList;
import java.util.List;

/**

* @Description: 加权有向图的数据类型

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class EdgeWeightedDigraph {
    /*定点总数*/
    private final int V;
    /*边的总数*/
    private int E;
    /*邻接表*/
    private List<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V){
        this.V=V;
        this.E=0;
        adj=new List[V];
        for (int v=0;v<V;v++){
            adj[v]=new ArrayList<>();
        }
    }

    public int getV(){
        return V;
    }
    public void addEdge(DirectedEdge e){
        adj[e.from()].add(e);
        E++;
    }

    public List<DirectedEdge> adj(int v){
        return adj[v];
    }
}
