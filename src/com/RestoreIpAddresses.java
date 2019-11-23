package com;



import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<Integer> pos=new ArrayList<>();
        List<String> ans=new ArrayList<>();
        traceBack(1,s,pos,ans);
        return ans;
    }

    private void traceBack(int v,String s,List<Integer> pos,List<String> ans){
        if (v>s.length()||!check(s,pos)){
            return;
        }
        if (pos.size()==3){
            /**处理结果*/
            int begin=pos.get(pos.size()-1);
            String temp=s.substring(begin);
            if (Integer.parseInt(temp)>255&&temp.length()>3){
                return;
            }
            StringBuilder stringBuilder=new StringBuilder(s);
            int k=0;
            for (int i:pos){
                stringBuilder.insert(i+k,'.');
                k++;
            }
            ans.add(stringBuilder.toString());
            return;
        }
        for (int i=v;i<s.length();i++){
            pos.add(i);
            traceBack(i+1,s,pos,ans);
            pos.remove(pos.size()-1);
        }
    }

    private boolean check(String s,List<Integer> pos){
        /**首先处理pos大小为0*/
        if (pos.size()==0){
            return true;
        }
        if (pos.size()==1){
            String temp=s.substring(0,pos.get(0));
            if (temp.length()>3||Integer.parseInt(temp)>255){
                return false;
            }
            return true;
        }
        int end=pos.get(pos.size()-1);
        int begin=pos.get(pos.size()-2);
        String temp=s.substring(begin,end);
        if (Integer.parseInt(temp)>255||temp.length()>3){
            return false;
        }
        if (temp.length()>1&&temp.charAt(0)=='0'){
            return false;
        }
        return true;
    }
}
