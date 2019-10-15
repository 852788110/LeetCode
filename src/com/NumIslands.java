package com;

public class NumIslands {
    public int numIslands(char[][] grid) {
        int ans=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    DFS(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void DFS(char[][] grid,int i,int j){
        grid[i][j]='0';
        /*up*/
        if (i>0&&grid[i-1][j]!='0'){
            DFS(grid,i-1,j);
        }
        /*down*/
        if (i<grid.length-1&&grid[i+1][j]!='0'){
            DFS(grid,i+1,j);
        }
        /*left*/
        if (j>0&&grid[i][j-1]!='0'){
            DFS(grid,i,j-1);
        }
        /*right*/
        if (j<grid[0].length-1&&grid[i][j+1]!='0'){
            DFS(grid,i,j+1);
        }
    }
}
