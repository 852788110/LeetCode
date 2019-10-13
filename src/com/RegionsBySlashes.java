package com;


/** 

* @Description: 提供一个巧妙的思路。将 / 转为
 * 001
 * 010
 * 100.
 * 空格转为
 * 000
 * 000
 * 000
 * \转为
 * 100
 * 010
 * 001。
 * 将原来n*n方格转为3n * 3n 方格。求0的连通量个数。
 * 比如
 * //
 * /
 * 转化为
 * 001001
 * 010010
 * 100100
 * 001000
 * 010000
 * 100000
 *
 * 作者：ma-dong-dong
 * 链接：https://leetcode-cn.com/problems/regions-cut-by-slashes/solution/mei-ge-xiao-ge-fen-jie-wei-3-3-fang-ge-qiu-lian-to/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

* @Param:  

* @return:  

* @Author: 刘洁

* @Date:  

*/ 

public class RegionsBySlashes {
    public int regionsBySlashes(String[] grid) {
        int N=grid.length;
        int[][] gridz=new int[3*N][3*N];
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if (grid[i].charAt(j)=='/'){
                    gridz[3*i][j*3+2]=1;
                    gridz[3*i+1][j*3+1]=1;
                    gridz[3*i+2][j*3]=1;
                }
                if (grid[i].charAt(j)=='\\'){
                    gridz[3*i][j*3]=1;
                    gridz[3*i+1][j*3+1]=1;
                    gridz[3*i+2][3*j+2]=1;
                }
            }
        }
        int count=0;
        for (int i=0;i<gridz.length;i++){
            for (int j=0;j<gridz.length;j++){
                if (gridz[i][j]==0){
                    DFS(gridz,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void DFS(int[][] gridz,int i,int j){
        gridz[i][j]=1;
        /*up*/
        if (i>0&&gridz[i-1][j]==0){
            DFS(gridz,i-1,j);
        }
        /*down*/
        if (i<(gridz.length-1)&&gridz[i+1][j]==0){
            DFS(gridz,i+1,j);
        }
        /*left*/
        if (j>0&&gridz[i][j-1]==0){
            DFS(gridz,i,j-1);
        }
        /*right*/
        if (j<(gridz.length-1)&&gridz[i][j+1]==0){
            DFS(gridz,i,j+1);
        }
    }
}
