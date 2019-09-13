package com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumTilePossibilities {
    int sum=0;
    private void backtrace(String tiles,Map<String,Integer> map){
        for (String s:map.keySet()) {
            if (map.get(s)>0){
                Map<String,Integer> temp=new HashMap<String,Integer>(map);
                Integer oldkey=map.get(s);
                temp.replace(s,oldkey-1);
                sum++;
                backtrace(tiles,temp);
            }
        }
    }

    public int numTilePossibilities(String tiles) {
        Map<String,Integer> map;
        map=new HashMap<String,Integer>();
        int N=tiles.length();
        for (int i=0;i<N;i++){
            if (map.containsKey(tiles.charAt(i)+"")){
                Integer oldvalue=map.get(tiles.charAt(i)+"");
                map.replace(tiles.charAt(i)+"",oldvalue+1);
            }else {
                map.put(tiles.charAt(i)+"",1);
            }
        }
        backtrace(tiles,map);
        return sum;
    }
}
