class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp=new int[n][n];
        return helper(0, n - 1,s,dp);
    }
    
    private int helper(int start, int end, String s,int[][] dp) {
        // Base case: when the pointers cross each other
        if (start > end) {
            return 0;
        }
        
        // Base case: single character is always a palindrome
        if (start == end) {
            return 1;
        }
        if(dp[start][end]!=0){
            return dp[start][end];
        }
        // If characters match, add 2 to the result of the inner subsequence
        if (s.charAt(start) == s.charAt(end)) {
            return dp[start][end]=2 + helper(start + 1, end - 1, s,dp);
        } else {
            // Otherwise, take the maximum of skipping either the start or the end character
            return dp[start][end]=Math.max(helper(start + 1, end, s,dp), 
                            helper(start, end - 1, s,dp));
        }
    }
}
