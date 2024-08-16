class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1); // Initialize dp array to -1 to indicate uncalculated states
        int result = helper(coins, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int helper(int[] coins, int amt, int[] dp) {
        if (amt == 0) {
            return 0; // If amount is 0, no coins are needed
        }
        if (amt < 0) {
            return Integer.MAX_VALUE; // If amount is negative, return impossible
        }
        if (dp[amt] != -1) {
            return dp[amt]; // Return the stored result if already computed
        }

        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = helper(coins, amt - coins[i], dp);
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, res + 1);
            }
        }

        dp[amt] = minCoins;
        return dp[amt];
    }
}
