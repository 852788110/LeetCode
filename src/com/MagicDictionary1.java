package com;

import java.util.HashMap;
import java.util.HashSet;

public class MagicDictionary1 {
    class TrieNode {
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];
    }
    TrieNode root;

    public MagicDictionary1() {
        root = new TrieNode();
    }

    public void buildDict(String[] dict) {
        for (String s: dict)
        {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++)
            {
                int pos = s.charAt(i) - 'a';
                if (cur.children[pos] == null)
                    cur.children[pos] = new TrieNode();
                cur = cur.children[pos];
            }
            cur.isWord = true;
        }
    }

    public boolean search(String word) {
        if (word.length() == 0)
            return false;
        if (search(word, root, false, 0))
            return true;
        return false;
    }


    public boolean search(String word, TrieNode root, boolean used, int start) {
        if(start == word.length())
            return root.isWord && used;

        char alpha = word.charAt(start);
        for (int i = 0; i < 26; i++)
        {
            if (root.children[i] == null)
                continue;
            if (alpha - 'a' == i)
            {
                if (search(word, root.children[i], used, start + 1))
                    return true;
            }
            else
            {
                if (!used && search(word, root.children[i], true, start + 1))
                    return true;
            }
        }
        return false;
    }
}
