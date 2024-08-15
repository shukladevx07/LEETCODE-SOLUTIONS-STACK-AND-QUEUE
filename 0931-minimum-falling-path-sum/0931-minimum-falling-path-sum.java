class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int minSum = Integer.MAX_VALUE;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        // Try all paths starting from the first row
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, helper(n - 1, col, matrix,dp));
        }
        
        return minSum;
    }
    
    private int helper(int row, int col, int[][] matrix,int[][] dp) {
        if (col < 0 || col >= matrix[0].length) {
            return Integer.MAX_VALUE; // Out of bounds
        }
        if (row == 0) {
            return matrix[0][col]; // Base case: first row
        }
        if(dp[row][col]!=Integer.MAX_VALUE){
            return dp[row][col];
        }
        
        int leftDiagonal = helper(row - 1, col - 1, matrix,dp);
        int rightDiagonal = helper(row - 1, col + 1, matrix,dp);
        int up = helper(row - 1, col, matrix,dp);

        return matrix[row][col] + Math.min(leftDiagonal, Math.min(rightDiagonal, up));
    }
}
