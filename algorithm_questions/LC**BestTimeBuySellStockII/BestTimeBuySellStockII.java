/**
  * difficulty: medium
  * url: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
  * tag: array, greedy
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int n = prices.length;
        int i = 0;
        int total = 0;
        while(i < n-1){
            int sell, buy;
            //find the stop point of the decreasing array
            while(i < n-1 && prices[i+1] < prices[i]) i++;
            buy = i;
            i++;//next point
            //find the stop point of the increasing array thereafter
            while(i < n && prices[i] >= prices[i-1]) i++;
            sell = i-1;
            total += prices[sell] - prices[buy];
        }
        return total;
    }
}

// method 2: if diff between prices[i], prices[i-1] > 0 add to maxProfit
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int total = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i]-prices[i-1]>0) total += prices[i]-prices[i-1];
        }
        return total;
    }
}