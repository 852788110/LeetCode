package com;

import java.util.*;

public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans=new ArrayList<>();
        if (nums.length==0) return ans;
        Map<Integer,Integer> map=new HashMap<>();

        PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for (int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i])){
                map.replace(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }

        //再使用堆排序
        for (Integer s:map.keySet()) {
                heap.add(s);
                if (heap.size()>k)  heap.poll();
        }

        while(heap.size()>0){
            ans.add(heap.poll());
        }
        return ans;
    }
}
