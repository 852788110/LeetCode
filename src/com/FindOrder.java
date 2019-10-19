package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindOrder {
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

    private boolean[] onStack;
    private boolean[] marked;
    private Digraph G;
    private boolean hasCycle;
    private Stack<Integer> reverseOrder;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length==0){
            return null;
        }
        marked=new boolean[numCourses];
        onStack=new boolean[numCourses];
        hasCycle=false;
        G=new Digraph(numCourses);
        reverseOrder=new Stack<>();
        for (int i=0;i<prerequisites.length;i++){
            int v=prerequisites[i][1];
            int w=prerequisites[i][0];
            G.addEdge(v,w);
        }

        for (int i=0;i<numCourses;i++){
            if (!marked[i]){
                dfs(i);
            }
        }
        int[] ans=new int[numCourses];
        if (hasCycle==true){
            return null;
        }else {
            for (int i=0;i<numCourses;i++){
                ans[i]=reverseOrder.pop();
            }
        }
        return ans;
    }

    private void dfs(int v){
        onStack[v]=true;
        marked[v]=true;
        for (int w:G.adj[v]){
            if (hasCycle==true){
                return;
            }else if (!marked[w]){
                dfs(w);
            }else if (onStack[w]){
                hasCycle=true;
            }
        }
        onStack[v]=false;
        reverseOrder.push(v);
    }
}




