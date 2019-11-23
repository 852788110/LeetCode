package com;

import java.util.*;

/**

* @Description: 这道题使用队列解决
 *             首先使用数组来统计每个字母出现的次数
 *             然后按照字典顺序，将他们加入到队列之中
 *             然后进行出队操作
 *
 *             这道题真他妈难
* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[] req=new int[26];
        for (int i=0;i<tasks.length;i++){
            int c=tasks[i]-'A';
            req[c]++;
        }

        Queue<Integer> queue=new LinkedList<>();
        int N=tasks.length;
        while (N > 0) {
            int temp=n+1;
            for (int i=0;i<26&&temp>0;i++){
                if (req[i]!=0){
                    queue.add(i);
                    req[i]--;
                    N--;
                    temp--;
                }
            }
        }

        int[] time=new int[26];
        int cur=n;
        while (!queue.isEmpty()){
            int t=queue.poll();
            int diff=cur-time[t];
            if (diff<n){
                cur+=n-diff;
            }
            cur++;
            time[t]=cur;
        }
        return cur-n;
    }
}
