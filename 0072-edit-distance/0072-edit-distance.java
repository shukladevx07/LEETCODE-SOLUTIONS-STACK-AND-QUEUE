class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int[][] dp=new int[n1][n2];
        return helper(n1-1,n2-1,word1,word2,dp);
    }
    private int helper(int n1,int n2,String w1,String w2,int[][] dp){
        if(n1<0){
            return n2+1;
        }
        if(n2<0){
            return n1+1;
        }
        if(dp[n1][n2]!=0){
            return dp[n1][n2];
        }
        if(w1.charAt(n1)==w2.charAt(n2)){
            return dp[n1][n2]=0+helper(n1-1,n2-1,w1,w2,dp);
        }
        int insert=1+helper(n1,n2-1,w1,w2,dp);
        int delete=1+helper(n1-1,n2,w1,w2,dp);
        int replace=1+helper(n1-1,n2-1,w1,w2,dp);

        return dp[n1][n2]=Math.min(insert,Math.min(delete,replace));
    }
}