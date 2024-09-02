class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Arrays to mark rows and columns that need to be zeroed
        boolean[] zeroRows = new boolean[n];
        boolean[] zeroCols = new boolean[m];

        // First pass: mark rows and columns that need to be zeroed
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        // Second pass: set the zeroes in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (zeroRows[i] || zeroCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
