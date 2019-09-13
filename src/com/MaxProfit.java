package com;

//先通过暴力求解
public class MaxProfit {
//    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//    如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
//
//    注意你不能在买入股票前卖出股票。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int maxProfit(int[] prices) {
        int ans=0;
        for (int i=0;i<prices.length;i++){
            int max=0;
            for (int j=i+1;j<prices.length;j++){
                if (prices[j]>max) max=prices[j];
            }
            int temp=max-prices[i];
            if (temp>ans) ans=temp;
        }
        return ans;
    }

}
