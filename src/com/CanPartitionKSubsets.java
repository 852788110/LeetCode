package com;

import java.util.HashMap;
import java.util.Map;
/**

* @Description:  这个答案理解错误

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class CanPartitionKSubsets {
    /**第一个Integer：所要寻找的数字   第二个Integer:表示那个数字还剩多少个*/
    private Map<Integer,Integer> map;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int N=nums.length;
        map=new HashMap<>(N);
        int sum=0;
        for (int i=0;i<N;i++){
            if (map.containsKey(nums[i])){
                map.replace(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
            sum+=nums[i];
        }
        int average=sum/k;
        for (int i=0;i<N;i++){
            if (map.get(nums[i])==0){
                continue;
            }

            int aim=average-nums[i];
            if (aim==0){
                continue;
            }
            if (!map.containsKey(aim)||map.get(aim)==0){
                return false;
            }
            map.replace(aim,map.get(aim)-1);
        }
        return true;
    }
}
