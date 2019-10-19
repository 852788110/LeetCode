package com;

import java.util.*;

public class CalcEquation1 {
    class Edge{
        String val;
        double quotient;
        Edge next;
        public Edge(String val,double quotient){
            this.val=val;
            this.quotient=quotient;
            this.next=null;
        }
    }

    private Map<String,Edge> graph;
    private double res;
    private HashSet<String> check;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph=new HashMap<>();
        int size=equations.size();
        /*构造图*/
        for (int i=0;i<size;i++){
            List<String> equation=equations.get(i);
            String s1=equation.get(0);
            String s2=equation.get(1);
            Edge e1=new Edge(s2,values[i]);
            Edge e2=new Edge(s1,1/values[i]);

            if (graph.containsKey(s1)){
                Edge temp=graph.get(s1);
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=e1;
            }else {
                graph.put(s1,e1);
            }

            if (graph.containsKey(s2)){
                Edge temp=graph.get(s2);
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=e2;
            }else {
                graph.put(s2,e2);
            }
        }

        res=-1.0;
        double[] ans=new double[queries.size()];

        for (int i=0;i<queries.size();i++){
            check=new HashSet<>();
            List<String> query=queries.get(i);
            String s1=query.get(0);
            String s2=query.get(1);
            double temp=1.0;
            calculate(s1,s2,temp);
            ans[i]=res;
            res=-1.0;
        }
        return ans;
    }

    private void calculate(String a,String b,double temp){
        check.add(a);
        if (a==b){
            res=temp;
        }
        Edge e=graph.get(a);
        while (e!=null) {
            if (!check.contains(e.val)) {
                calculate(e.val, b, temp * e.quotient);
            }
            e = e.next;
        }
    }
}
