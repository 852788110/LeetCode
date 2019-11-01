package com;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens1 {
    private int[][] chess;
    private  int row;
    private  int col;
    private List<List<String>> ans;
    private char queue='Q';
    private char unQueue='.';

    public List<List<String>> solveNQueens(int n) {
        chess=new int[n][n];
        row=n;
        col=n;
        ans=new ArrayList<>();
        findQueue(0);
        return ans;
    }
    private void findQueue(int m){
        if (m+1>col){
            List<String> str=new ArrayList<>();
            for (int i=0;i<col;i++){
                StringBuilder sb=new StringBuilder();
                for (int j=0;j<col;j++){
                    if (chess[i][j]==1){
                        sb.append(queue);
                    }else {
                        sb.append(unQueue);
                    }
                }
                str.add(sb.toString());
            }
            ans.add(str);
        }
        for (int i=0;i<col;i++){
            if (check(m,i)){
                chess[m][i]=1;
                findQueue(m+1);
                chess[m][i]=0;
            }
        }
    }

    /**m:摆放棋子的行     n：摆放棋子的列*/
    /**返回true：表明能在此处摆放棋子
     * 反之，产生冲突*/
    private boolean check(int m,int n){
        /**检查列冲突*/
        for (int k=0;k<m;k++){
            if (chess[k][n]==1){
                return false;
            }
        }

        /**检查左对角线冲突
         * 由于是从上往下摆放棋子，故只检查上方已摆放棋子是否产生冲突*/
        for (int i=m-1,j=n-1;i>=0&&j>=0;i--,j--){
            if (chess[i][j]==1){
                return false;
            }
        }

        /**检查右对角线冲突
         *由于是从上往下摆放棋子，故只检查上方已摆放棋子是否产生冲突 */
        for(int i=m-1,j=n+1;i>=0&&j<col;i--,j++){
            if (chess[i][j]==1){
                return false;
            }
        }
        return true;
    }
}
