package com;


/**

* @Description: 把它当作无向图，看他有多少个连通分量

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class FindCircleNum {
    public int findCircleNum(int[][] M) {
        boolean[] N=new boolean[M.length];
        for (int i=0;i<N.length;i++){
            N[i]=false;
        }
        int ans=0;
        for (int i=0;i<M.length;i++){
            if (N[i]==false){
                DFS(M,N,i);
                ans++;
            }
        }
        return ans;
    }

    private void DFS(int[][] M,boolean[] N,int i){
        N[i]=true;
        for (int j=0;j<M.length;j++){
            if (M[i][j]==1&&N[j]==false){
                DFS(M,N,j);
            }
        }
    }
}
