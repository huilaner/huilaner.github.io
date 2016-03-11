/**
  * difficulty: medium
  * url: http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock-iii/
  * tag: greedy
*/
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     * test: [], [1], [1,2], [1,2,3], [3,2,1], [2,4,1,5,6]
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int n = prices.length;
        //wanna find two max, max(0, i), and max(i+1, n)
        int[] maxFromLeft = new int[n]; //max at i compare with left
        int[] maxFromRight = new int[n]; // max at i compare with right

        int min = prices[0];
        maxFromLeft[0] = 0;
        for(int i  = 1; i < n; i++){
            min = Math.min(min, prices[i]);
            maxFromLeft[i] = Math.max(maxFromLeft[i-1], prices[i] - min);
        }

        int max = prices[n-1];
        maxFromRight[n-1] = 0;
        for(int i =  n -2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            maxFromRight[i] = Math.max(maxFromRight[i+1], max - prices[i]);
        }

        int profit = 0;
        for(int i = 0; i < n; i++){
            profit = Math.max(profit, maxFromLeft[i] + maxFromRight[i]);
        }

        return profit;
    }
};
