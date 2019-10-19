package com;

import java.util.List;

public class CanVisitAllRooms {
    private boolean[] check;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int nums=rooms.size();
        check=new boolean[nums];
        for (int i=0;i<nums;i++){
            check[i]=false;
        }
        DFS(0,rooms);
        for (int i=0;i<nums;i++){
            if (check[i]==false){
                return false;
            }
        }
        return true;
    }

    private void DFS(int i,List<List<Integer>> rooms){
        List<Integer> room=rooms.get(i);
        check[i]=true;
        for (int j=0;j<room.size();j++){
            int k=room.get(j);
            if (check[k]==false){
                DFS(k,rooms);
            }
        }
    }
}
