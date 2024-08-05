class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(minCost(n - 1, cost), minCost(n - 2, cost));
    }

    private int minCost(int i, int[] cost) {
        int[] dp=new int[cost.length+1];
        if (i < 0) {
            return 0;
        }
        dp[0]=cost[0];
        dp[1]=cost[1];
        if(dp[i]!=0) return dp[i];
        else
        return dp[i]=cost[i] + Math.min(minCost(i - 1, cost), minCost(i - 2, cost));
    }
}
