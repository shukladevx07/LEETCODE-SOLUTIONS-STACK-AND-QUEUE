class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return helper(prices, 0, 0,dp);
    }
    
    private int helper(int[] prices, int index, int holding,int[][] dp) {
        // Base case: if we have reached the end of the array, no more profit can be made
        if (index >= prices.length) {
            return 0;
        }
        if(dp[index][holding]!=-1){
            return dp[index][holding];
        }
        // Skip the current day
        int skip = helper(prices, index + 1, holding,dp);
        
        if (holding == 0) {
            // We don't hold any stock, so we can either buy today or skip
            int buy = helper(prices, index + 1, 1,dp) - prices[index];
            return dp[index][holding]=Math.max(skip, buy);
        } else {
            // We are holding a stock, so we can either sell today or skip
            int sell = helper(prices, index + 1, 0,dp) + prices[index];
            return dp[index][holding]=Math.max(skip, sell);
        }
    }
}
