package com;
/*输入: [7,1,5,3,6,4]
        输出: 7
        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
        随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class MaxProfit_1 {
    public int maxProfit(int[] prices) {
        int lens=prices.length,ans=0,def=0;
        for (int i=1;i<lens;i++){
            def=prices[i]-prices[i-1];
            if (def>0) ans+=def;
        }
        return ans;
    }
}
