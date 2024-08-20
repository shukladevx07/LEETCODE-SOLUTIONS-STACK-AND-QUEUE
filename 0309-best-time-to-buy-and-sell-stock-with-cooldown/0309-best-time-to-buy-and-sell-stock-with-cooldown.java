class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0) return 0;
        int[][] dp = new int[n][2];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(0, 1, prices, dp);
    }

    private int helper(int ind, int buy, int[] prices, int[][] dp) {
        if (ind >= prices.length) {
            return 0;
        }
        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }
        if (buy == 1) {
            return dp[ind][buy] = Math.max(-prices[ind] + helper(ind + 1, 0, prices, dp),
                    0 + helper(ind + 1, 1, prices, dp));
        } else {
            return dp[ind][buy]= Math.max(+prices[ind] + helper(ind + 2, 1, prices, dp),
                    0 + helper(ind + 1, 0, prices, dp));
        }
    }
}