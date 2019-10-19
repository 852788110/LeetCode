package com;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**

* @Description: 使用深度优先搜索判断图中是否有环

* @Param:

* @return:

* @Author: 刘洁

* @Date:  17点36分

*/

public class CanFinish {
    class Digraph{
        private int V;
        private List<Integer>[] adj;

        public Digraph(int V){
            this.V=V;
            adj=new List[V];
            for (int v=0;v<V;v++){
                adj[v]=new ArrayList<>();
            }
        }

        public void addEdge(int v,int w){
            adj[v].add(w);
        }
    }

    private boolean[] marked;
    private boolean[] onStack;
    private boolean hasCycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        marked=new boolean[numCourses];
        onStack=new boolean[numCourses];
        hasCycle=false;
        Digraph G=new Digraph(numCourses);
        for (int i=0;i<prerequisites.length;i++){
            int v=prerequisites[i][1];
            int w=prerequisites[i][0];
            G.addEdge(v,w);
        }

        for (int i=0;i<numCourses;i++){
            if (marked[i]!=true){
                dfs(G,i);
            }
        }
        return !hasCycle;
    }

    private void dfs(Digraph G,int v){
        onStack[v]=true;
        marked[v]=true;
        for (int w:G.adj[v]){
            if (hasCycle==true){
                return;
            }else if (!marked[w]){
                dfs(G,w);
            }else if (onStack[w]){
                hasCycle=true;
                return;
            }
        }
        onStack[v]=false;
    }
}
