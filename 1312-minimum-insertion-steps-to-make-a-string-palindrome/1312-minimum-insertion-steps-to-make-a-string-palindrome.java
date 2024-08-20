class Solution {
    public int minInsertions(String s) {
        int e = s.length();
        int[][] dp=new int[e][e];
        return helper(0, e - 1, s,dp);
    }

    private int helper(int s, int e, String S,int[][] dp) {
        if (s >= e) {
            return 0;
        }
        if(dp[s][e]!=0){
            return dp[s][e];
        }

        if (S.charAt(s) == S.charAt(e)) {
            return dp[s][e]= helper(s + 1, e - 1, S,dp);
        } else {
            int insertAtStart = helper(s + 1, e, S,dp);
            int insertAtEnd = helper(s, e - 1, S,dp);
            return dp[s][e]=1 + Math.min(insertAtStart, insertAtEnd);
        }
    }
}
