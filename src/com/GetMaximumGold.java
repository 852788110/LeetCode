package com;

public class GetMaximumGold {
    private int maxGold;
    private int[][] grid;
    /**m:行数 n:列数*/
    private int m;
    private int n;
    public int getMaximumGold(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        this.grid=grid;
        this.maxGold=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]!=0){
                    traceBack(i,j,0);
                }
            }
        }
        return maxGold;
    }

    private void traceBack(int i,int j,int sum){
        sum+=grid[i][j];
        int preGold=grid[i][j];
        grid[i][j]=0;
        if (sum>maxGold){
            maxGold=sum;
        }
        /**向上走*/
        if (i-1>=0&&grid[i-1][j]!=0){
            traceBack(i-1,j,sum);
        }
        /**向下走*/
        if (i+1<m&&grid[i+1][j]!=0){
            traceBack(i+1,j,sum);
        }
        /**向左走*/
        if (j-1>=0&&grid[i][j-1]!=0){
            traceBack(i,j-1,sum);
        }
        /**向右走*/
        if (j+1<n&&grid[i][j+1]!=0){
            traceBack(i,j+1,sum);
        }
        grid[i][j]=preGold;
        sum-=preGold;
    }
}
