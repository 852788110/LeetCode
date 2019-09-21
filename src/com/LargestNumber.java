package com;

import java.util.*;

//对数组中的数进项字典排序
public class LargestNumber implements Comparator<String>{

    public String largestNumber(int[] nums) {
        int lens=nums.length;
        String[] str=new String[lens];
        String ans="";
        for (int i=0;i<lens;i++){
            str[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(str,new LargestNumber());
        if (str[0].equals("0")) {
            return "0";
        }
        for (int i=0;i<lens;i++){
            ans+=str[i];
        }
        return ans;
    }

    @Override
    public int compare(String o1, String o2) {
        String order1=o1+o2;
        String order2=o2+o1;
        return order2.compareTo(order1);
    }
}
