package com;

import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class Dijkstra {

    private DirectedEdge[] edgeTo;
    private int[] distTo;
    private IndexMinPQ<Integer> pq;
    public Dijkstra(EdgeWeightedDigraph G,int s){
        edgeTo=new DirectedEdge[G.getV()];
        distTo=new int[G.getV()];
        pq=new IndexMinPQ<>(G.getV());
        for (int v=0;v<G.getV();v++){
            distTo[v]=Integer.MAX_VALUE;
        }
        distTo[s]=0;
        pq.insert(s,0);
        while(!pq.isEmpty()){
            relax(G,pq.delMin());
        }
    }

    private void relax(EdgeWeightedDigraph G,int v){
        for (DirectedEdge e:G.adj(v)){
            int w=e.to();
            if (distTo[w]>distTo[v]+e.getWeight()){
                distTo[w]=distTo[v]+e.getWeight();
                edgeTo[w]=e;
                if (pq.contains(w)){
                    pq.changeKey(w,distTo[w]);
                }else {
                    pq.insert(w,distTo[w]);
                }
            }

        }
    }
}



