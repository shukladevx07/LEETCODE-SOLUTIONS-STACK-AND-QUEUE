import java.util.Arrays;
class Solution {
    public int tribonacci(int n) {
         if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        return tribonacciHelper(n, dp);
    }
    private int tribonacciHelper(int n, int[] dp) {
        if (dp[n] != -1) return dp[n];
        dp[n] = tribonacciHelper(n - 1, dp) + tribonacciHelper(n - 2, dp) + tribonacciHelper(n - 3, dp);
        return dp[n];
    }
}