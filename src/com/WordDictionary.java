package com;

import java.util.*;

/** 

* @Description: 这个方法超时 

* @Param:  

* @return:  

* @Author: 刘洁

* @Date:  

*/ 

public class WordDictionary {
    private char lamb='.';
    private HashSet<String> words;
    /** Initialize your data structure here. */
    public WordDictionary() {
        words=new HashSet<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        words.add(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (words.contains(word)){
            return true;
        }else if (isLam(word)){
            Iterator<String> str=words.iterator();
            while(str.hasNext()){
                String temp=str.next();
                if (temp.length()!=word.length()){
                    continue;
                }
                int i;
                for (i=0;i<word.length();i++){
                    if (!(word.charAt(i)==lamb||word.charAt(i)==temp.charAt(i))){
                        break;
                    }
                }
                if (i==word.length()){
                    return true;
                }
            }
        }
        return false;
    }

    /**检查单词中是否有正则表达式*/
    private boolean isLam(String word){
        for (int i=0;i<word.length();i++){
            if (word.charAt(i)==lamb){
                return true;
            }
        }
        return false;
    }

}
