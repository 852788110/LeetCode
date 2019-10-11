package com;

public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums)// 一样的抵消,不一样的两个数字异或运算结果必定有一位是1
            xor ^= i;

        int mask = xor & (-xor);

        int[] ans = new int[2];
        for (int i : nums) {
            if ((i & mask) == 0)//== 0、 == mask 两种结果
                ans[0] ^= i;
            else
                ans[1] ^= i;
        }
        return ans;
    }

    public int singleNumber3(int[] nums){
        int ones = 0, twos = 0, threes = 0;
        for(int num : nums){
            twos |= ones & num;
            ones ^= num;
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}
