package com;

/*在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

        示例 1:

        输入: [3,2,1,5,6,4] 和 k = 2
        输出: 5

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.Arrays;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int lens=nums.length;
        return nums[lens-k];
    }
}
