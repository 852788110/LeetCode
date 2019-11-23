package com;

/** 

* @Description: 1、局部变量的执行效率会更高
 * 2、在处理循环体代码段时或者对时间要求高的场合尽量使用局部变量。 

* @Param:  

* @return:  

* @Author: 刘洁

* @Date:  

*/ 

public class CountArrangement {
    private int N;
    private boolean[] onMarked;
    private int ans;
    public int countArrangement(int N) {
        this.N=N;
        onMarked=new boolean[N+1];
        ans=0;
        traceBack(1);
        return ans;
    }

    private void traceBack(int d){
        if (d>N){
            ans++;
            return;
        }
        for (int i=1;i<=N;i++){
            if (onMarked[i]==false&&(i%d==0||d%i==0)){
                onMarked[i]=true;
                traceBack(d+1);
                onMarked[i]=false;
            }
        }
    }
}
