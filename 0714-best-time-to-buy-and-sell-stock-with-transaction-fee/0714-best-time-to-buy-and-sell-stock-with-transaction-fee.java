class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,1,prices,fee,dp);
    }
    private int helper(int n,int buy,int[] prices,int fee,int[][] dp){
        if(n>=prices.length){
            return 0;
        }
        if(dp[n][buy]!=-1){
            return dp[n][buy];
        }
        if(buy==1){
            return dp[n][buy]=Math.max(-prices[n]-fee+helper(n+1,0,prices,fee,dp),0+helper(n+1,1,prices,fee,dp));
        }
        return dp[n][buy]=Math.max(+prices[n]+helper(n+1,1,prices,fee,dp),0+helper(n+1,0,prices,fee,dp));

    }
}