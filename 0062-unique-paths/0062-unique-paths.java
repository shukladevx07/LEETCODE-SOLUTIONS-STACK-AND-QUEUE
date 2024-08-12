class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1]; // Initialize memoization table
        return uniquePathsHelper(m, n, dp);
    }
    
    private int uniquePathsHelper(int m, int n, int[][] dp) {
        // Base case: if there's only one row or one column, there's only one path
        if (m == 1 || n == 1) {
            return 1;
        }
        
        // If already calculated, return the stored value
        if (dp[m][n] != 0) {
            return dp[m][n];
        }
        
        // Recursive calls with memoization
        dp[m][n] = uniquePathsHelper(m - 1, n, dp) + uniquePathsHelper(m, n - 1, dp);
        
        return dp[m][n];
    }
}
