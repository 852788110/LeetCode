package com;

public class Solve {
    public void solve(char[][] board) {
        char[][] fake=new char[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                fake[i][j]=board[i][j];
            }
        }
        int M=board.length,N=board[0].length;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]=='O'){
                    DFS(board,i,j);
                }
            }
        }
        //up
        for (int j=0;j<N;j++){
            if (fake[0][j]=='O'){
                DFS2(fake,board,0,j);
            }
        }
        /*down*/
        for (int j=0;j<N;j++){
            if (fake[M-1][j]=='O'){
                DFS2(fake,board,M-1,j);
            }
        }
        /*left*/
        for (int i=0;i<M;i++){
            if (fake[i][0]=='O'){
                DFS2(fake,board,i,0);
            }
        }
        /*right*/
        for (int i=0;i<M;i++){
            if (fake[i][N-1]=='O'){
                DFS2(fake,board,i,N-1);
            }
        }
    }

    private void DFS(char[][] board,int i,int j){
        board[i][j]='X';
        /*up*/
        if (i>0&&board[i-1][j]=='O'){
            DFS(board,i-1,j);
        }
        /*down*/
        if (i+1<board.length&&board[i+1][j]=='O'){
            DFS(board,i+1,j);
        }
        /*left*/
        if (j>0&&board[i][j-1]=='O'){
            DFS(board,i,j-1);
        }
        /*right*/
        if (j<board[0].length-1&&board[i][j+1]=='O'){
            DFS(board,i,j+1);
        }
    }
    private void DFS2(char[][] fake,char[][] board,int i,int j){
        fake[i][j]='X';
        board[i][j]='O';
        /*up*/
        if (i>0&&fake[i-1][j]=='O'){
            DFS2(fake,board,i-1,j);
        }
        /*down*/
        if (i+1<fake.length&&fake[i+1][j]=='O'){
            DFS2(fake,board,i+1,j);
        }
        /*left*/
        if (j>0&&fake[i][j-1]=='O'){
            DFS2(fake,board,i,j-1);
        }
        /*right*/
        if (j<fake[0].length-1&&fake[i][j+1]=='O'){
            DFS2(fake,board,i,j+1);
        }
    }
}
