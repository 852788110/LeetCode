package com;

import java.util.List;

public class CalcEquation {
    private double[][] graph;
    private double res=-1.0;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph=new double[26][26];
        int lens=equations.size();
        for (int i=0;i<lens;i++){
            List<String> equation=equations.get(i);
            char s1=equation.get(0).charAt(0);
            char s2=equation.get(1).charAt(0);
            int c1=s1-'a',c2=s2-'a';
            graph[c1][c2]=values[i];
            graph[c2][c1]=1/values[i];
            graph[c1][c1]=1;
            graph[c2][c2]=1;
        }

        int nums=queries.size();
        double[] ans=new double[nums];
        for (int i=0;i<nums;i++){
            List<String> query=queries.get(i);
            char s1=query.get(0).charAt(0);
            char s2=query.get(1).charAt(0);
            int c1=s1-'a',c2=s2-'a';
            boolean[] check=new boolean[26];
            double temp=1.0;
            if (graph[c1][c1]==0){
                ans[i]=-1.0;
                continue;
            }
            calc(c1,c2,temp,check);
            ans[i]=res;
            res=-1.0;
        }
        return ans;
    }

    /*求解a/b*/
    private void calc(int a,int b,double temp,boolean[] check){
        check[a]=true;

        if (a==b){
            res=temp;
            return;
        }
        for (int i=0;i<26;i++){
            if (graph[a][i]!=0&&check[i]==false){
                calc(i,b,temp*graph[a][i],check);
            }
        }
    }
}
