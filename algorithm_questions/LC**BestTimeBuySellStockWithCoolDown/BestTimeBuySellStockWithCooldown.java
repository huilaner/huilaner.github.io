/**
  * difficulty: meidum
  * url: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
  * tag: DP
*/
public class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0, prevSell = 0, buy = Integer.MIN_VALUE, prevBuy = 0;
        for(int price : prices){
            //buy[i] = max(sell[i-2]-price, buy[i-1]) buy or not-keep prev buy
            //sell[i] = max(buy[i-1]+price, sell[i-1]) sell or not sell-keep prev sell
            prevBuy = buy;
            buy = Math.max(prevSell-price, prevBuy);
            prevSell = sell;
            sell = Math.max(prevBuy+price, prevSell);
        }
        return sell;
    }
}