package com;

public class MinPathSum {
    //这个方法行不通
    /*public int minPathSum(int[][] grid) {
        int height=grid.length,width=grid[0].length;
        int[][] res=new int[height][width];
        return minPath(height-1,width-1,res,grid);
    }

    private int minPath(int i,int j,int[][] res,int[][] grid){
        if (i==0&&j==0) return grid[0][0];
        int temp1=0,temp2=0;
        if ((i-1)>0){
            if (res[i-1][j]<=0){
                res[i-1][j]=minPath(i-1,j,res,grid);
            }
            temp1=res[i-1][j]+grid[i][j];
        }
        if ((j-1)>0){
            if (res[i][j-1]<=0){
                res[i][j-1]=minPath(i,j-1,res,grid);
            }
            temp2=res[i][j-1]+grid[i][j];
        }
        return Math.min(temp1,temp2);
    }*/
}
