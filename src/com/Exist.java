package com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exist {
    public boolean exist(char[][] board, String word) {
        if (board.length==0){
            return false;
        }
        boolean[][] onMarked=new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==word.charAt(0)){
                    traceBack(i,j,0,board,word,onMarked);
                }
                if (ans==true){
                    return ans;
                }
            }
        }
        return ans;
    }

    private boolean ans=false;
    private void traceBack(int i,int j,int d,char[][] board,String word,boolean[][] onMarked){
        if (ans==true){
            return;
        }
        if (d==word.length()-1){
            ans=true;
            return;
        }
        onMarked[i][j]=true;
        /**向上*/
        if (i-1>=0&&board[i-1][j]==word.charAt(d+1)&&onMarked[i-1][j]==false){
            traceBack(i-1,j,d+1,board,word,onMarked);
        }
        /**向下*/
        if (i+1<board.length&&board[i+1][j]==word.charAt(d+1)&&onMarked[i+1][j]==false){
            traceBack(i+1,j,d+1,board,word,onMarked);
        }
        /**向左*/
        if (j-1>=0&&board[i][j-1]==word.charAt(d+1)&&onMarked[i][j-1]==false){
            traceBack(i,j-1,d+1,board,word,onMarked);
        }
        /**向右*/
        if (j+1<board[0].length&&board[i][j+1]==word.charAt(d+1)&&onMarked[i][j+1]==false){
            traceBack(i,j+1,d+1,board,word,onMarked);
        }
        onMarked[i][j]=false;
    }
}
