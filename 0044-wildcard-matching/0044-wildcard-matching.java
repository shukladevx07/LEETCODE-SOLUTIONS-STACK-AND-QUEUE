class Solution {
    public boolean isMatch(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        int[][] dp = new int[n1 + 1][n2 + 1]; // Adjust the size of dp array to include base cases
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                dp[i][j] = -1; // Initialize dp array with -1 to indicate uncomputed states
            }
        }
        return helper(n1, n2, s, p, dp);
    }

    private boolean helper(int n1, int n2, String s, String p, int[][] dp) {
        if (n1 == 0 && n2 == 0) {
            return true;
        }
        if (n2 == 0) {
            return false;
        }
        if (n1 == 0) {
            for (int i = 0; i < n2; i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        
        if (dp[n1][n2] != -1) {
            return dp[n1][n2] == 1;
        }

        boolean match = false;
        if (p.charAt(n2 - 1) == s.charAt(n1 - 1) || p.charAt(n2 - 1) == '?') {
            match = helper(n1 - 1, n2 - 1, s, p, dp);
        } else if (p.charAt(n2 - 1) == '*') {
            match = helper(n1 - 1, n2, s, p, dp) || helper(n1, n2 - 1, s, p, dp);
        }

        dp[n1][n2] = match ? 1 : 0;
        return match;
    }
}
