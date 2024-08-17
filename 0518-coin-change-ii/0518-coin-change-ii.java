class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<amount+1;j++){
                dp[i][j]=-1;
            }
        }
        return helper(n-1,amount,coins,dp);
        
    }
    private int helper(int n,int amt,int[] coins,int[][] dp){
        if(amt==0){
            return 1;
        }
        if (n < 0 || amt < 0) {
            return 0;
        }
        if(dp[n][amt]!=-1){
            return dp[n][amt];
        }
        int nottake=helper(n-1,amt,coins,dp);
        int take=0;
        if(amt>=coins[n]){
            take=helper(n,amt-coins[n],coins,dp);
        }
        return dp[n][amt]=take+nottake;
    }
}