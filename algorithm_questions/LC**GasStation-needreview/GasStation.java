/**
  * difficulty: medium
  * url: https://leetcode.com/problems/gas-station/
  * tag: greedy
  * ref: https://leetcode.com/discuss/4159/share-some-of-my-ideas
  **** need review ***
*/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0 || cost.length == 0 || gas.length != cost.length) return -1;
        int start = 0, tank = 0, total = 0;
        for(int i = 0; i < gas.length; i++){
            tank = tank + gas[i] - cost[i];
            if(tank < 0){
                start = i+1;
                total += tank;
                tank = 0;
            }
        }
        return total+tank<0 ? -1 : start;
    }
}
