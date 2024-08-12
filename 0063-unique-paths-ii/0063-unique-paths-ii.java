class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n]; // Use m x n size

        // Initialize dp array with -1 indicating unvisited cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(m - 1, n - 1, obstacleGrid, dp);
    }

    private int helper(int m, int n, int[][] obstacleGrid, int[][] dp) {
        // Base cases
        if (m < 0 || n < 0 || obstacleGrid[m][n] == 1) {
            return 0; // If out of bounds or obstacle, no path
        }
        if (m == 0 && n == 0) {
            return 1; // Reached the starting point
        }

        // If already calculated, return the stored value
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        // Recursive calls for up and left cells
        int left = helper(m, n - 1, obstacleGrid, dp);
        int up = helper(m - 1, n, obstacleGrid, dp);

        // Store the result in dp array
        dp[m][n] = left + up;

        return dp[m][n];
    }
}
