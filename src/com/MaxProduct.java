package com;

public class MaxProduct {
    public int maxProduct(String[] words) {
        int lens=words.length;
        int[] two={1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536
        ,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432};
        int[] nums=new int[lens];
        int maxlength=0;
        for (int i=0;i<lens;i++){
            String word=words[i];
            for (int j=0;j<word.length();j++){
                int t=word.charAt(j)-'a';
                nums[i]=nums[i]|two[t];
            }
        }
        for(int i=0;i<lens;i++){
            for (int j=i+1;j<lens;j++){
                int res=nums[i]&nums[j];
                if (res==0){
                    int length=words[i].length()*words[j].length();
                    if (maxlength<length) maxlength=length;
                }
            }
        }
        return maxlength;
    }
}
