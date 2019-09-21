package com;

import java.util.*;

//对数组中的数进项字典排序
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int lens=nums.length;
        List<String> str=new ArrayList<>();
        for (Integer t:nums) {
            str.add(t+"");
        }
        str.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()==o2.length()) return o1.compareTo(o2);
                else if (o1.length()>o2.length()){
                    int len1=o1.length(),len2=o2.length();
                }
            }
        }.);
    }

}
