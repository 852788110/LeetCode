package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CamelMatch {
    class Node{
        List<Character> list;
        Node next;
        public Node(){
            list=new ArrayList<>();
            next=null;
        }
    }
    /**root：空结点，不包含实际值*/
    private char[] pat;
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        pat=new char[pattern.length()];
        List<Boolean> ans=new ArrayList<>();
        for (int i=0;i<pattern.length();i++){
            pat[i]=pattern.charAt(i);
        }
        for (String str:queries){
            ans.add(check(str));
        }
        return ans;
    }

    private boolean check(String query){
        int k=0;
        for (int i=0;i<query.length();i++){
            char c=query.charAt(i);
            if (c<'a'){
                if (k>=pat.length){
                    return false;
                }
                if (c!=pat[k]){
                    return false;
                }
                k++;
            } else if (c>='a'){
               if (k<pat.length&&c==pat[k]){
                   k++;
               }
            }
        }
        if (k<pat.length){
            return false;
        }
        return true;
    }
}
