class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k1 = 0; k1 <=k; k1++) {
                    dp[i][j][k1] = -1;
                }
            }
        }
        return helper(0, 1, k, prices, dp);
    }
    private int helper(int ind, int buy, int cap, int[] prices, int[][][] dp) {
        if (cap == 0) {
            return 0;
        }
        if (ind == prices.length) {
            return 0;
        }
        if(dp[ind][buy][cap]!=-1){
            return dp[ind][buy][cap];
        }
        if (buy == 1) {
            return dp[ind][buy][cap] = Math.max(-prices[ind] + helper(ind + 1, 0, cap, prices, dp),
                    0 + helper(ind + 1, 1, cap, prices, dp));
        } else {
            return dp[ind][buy][cap] = Math.max(+prices[ind] + helper(ind + 1, 1, cap - 1, prices, dp),
                    0 + helper(ind + 1, 0, cap, prices, dp));
        }
    }
}