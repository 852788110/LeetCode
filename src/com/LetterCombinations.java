package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public void backtrace(String cur,List<String> ans,List<String> result,int no,int max){
        if (cur.length()>=max){
            result.add(cur);
            return;
        }
        int N=ans.get(no).length();
        String st=ans.get(no);
        for (int i=0;i<N;i++){
            backtrace(cur+st.charAt(i),ans,result,no+1,max);
        }
    }

    //首先，建立多个数组，列出其所对应的字母
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0) return null;
        Map<String,String> map=new HashMap<String,String>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxuz");
        List<String> ans=new ArrayList<String>();
        for (int i=0;i<digits.length();i++){
            String test=digits.charAt(i)+"";
            String temp=map.get(digits.charAt(i)+"");
            ans.add(temp);
        }
        List<String> result=new ArrayList<String>();
        String cur="";
        backtrace(cur,ans,result,0,digits.length());
        return  result;
    }
}
