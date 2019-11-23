package com;

/**

* @Description: 构建一个满二叉树

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        if (piles.length==2){
            return true;
        }
        /**先取前面的石头*/
        int head=piles[0];
        int next1=piles[1],next2=piles[piles.length-1];
        if (head>=next1&&head>=next2){
            return true;
        }
        /**取后面的石头*/
        int rear=next2;
        next1=head;
        next2=piles[piles.length-2];
        if (rear>=next1&&rear>=next2){
            return true;
        }
        return false;
    }

    /*private int[] buildTree(int[] piles){
        int[] tree=new int[4];
    }*/
}
