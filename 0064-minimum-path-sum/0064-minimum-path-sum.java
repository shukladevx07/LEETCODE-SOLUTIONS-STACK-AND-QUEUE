class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return minPathSumHelper(grid, m - 1, n - 1,dp);
    }

    private int minPathSumHelper(int[][] grid, int row, int col,int[][] dp) {
        // Base case: if out of bounds, return a large number (infinity equivalent)
        // because we shouldn't consider this path
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }

        // If we've reached the top-left corner, return its value
        if (row == 0 && col == 0) {
            return grid[row][col];
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        // Recursively calculate the minimum path sum from the left and above cells
        return dp[row][col]=grid[row][col] + Math.min(minPathSumHelper(grid, row, col - 1,dp), 
                                         minPathSumHelper(grid, row - 1, col,dp));
    }
}
