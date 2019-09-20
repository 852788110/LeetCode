package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PancakeSort1 {
    public List<Integer> pancakeSort(int[] a) {
        int len = a.length;
        if (len <= 1) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = len; i >= 1; i--) {

            int pos = findMaxPosition(i, a);
            if (pos == i) {
                continue;
            }

            list.add(pos);
            reverse(a, pos);
            list.add(i);
            reverse(a, i);
        }
        return list;
    }

    private void reverse(int[] a, int num) {
        int i = 0, j = num - 1;
        int temp;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    private int findMaxPosition(int max, int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            if (a[i] == max) {
                return i + 1;
            }
        }
        return -1;
    }
/*
    作者：jessenpan
    链接：https://leetcode-cn.com/problems/pancake-sorting/solution/java-xian-zhi-huan-zui-da-yuan-su-zai-jiang-zui-da/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
