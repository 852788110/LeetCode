package com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindLongestWord {
    public String findLongestWord(String s, List<String> d) {
        if (s.length()==0) return "";
        d.sort(Comparator.comparing(String::length).reversed().thenComparing((a,b)->a.compareTo(b)));
        for (int i=0;i<d.size();i++){
            String lg=d.get(i);
            int j=0,k=0;
            int jlens=s.length(),klens=lg.length();
            while(j<jlens&&k<klens){
                if (lg.charAt(k)==s.charAt(j)){
                    k++;j++;
                }else j++;
            }
            if (j<jlens) return lg;
        }
        return "";
    }
}
