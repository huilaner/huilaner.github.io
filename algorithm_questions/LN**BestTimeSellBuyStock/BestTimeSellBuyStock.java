/**
  * difficulty: medium
  * url: http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock/
  * tag: greedy, enumeration, array
  * test: [1,3,2,3,2,100,98,2]
*/
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */

    //track min
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        int profit = 0;
        int min = Integer.MAX_VALUE;
        
        for(int price : prices){
           if(min > price) min = price;
           if(profit < price - min) profit = price - min;
        }
        
        return profit;
    }

    //track max
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        int profit = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = prices.length - 1; i >= 0; i--){
           int price = prices[i];
           if(max < price) max = price;
           if(profit < max - price) profit = max - price;
        }
        
        return profit;
    }
}

