package com;


/**

* @Description: 加权有向边的数据类型

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class DirectedEdge {
    /*边的起点*/
    private final int v;
    /*边的终点*/
    private final int w;
    /*边的权重*/
    private final int weight;

    public DirectedEdge(int v,int w,int weight){
        this.v=v;
        this.w=w;
        this.weight=weight;
    }

    public int getWeight(){
        return weight;
    }

    public int from(){
        return v;
    }

    public int to(){
        return w;
    }

    @Override
    public String toString(){
        return String.format("%d->%d %.2f",v,w,weight);
    }
}
