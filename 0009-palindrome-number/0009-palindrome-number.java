class Solution {
    public boolean isPalindrome(int x) {
        String s=Integer.toString(x);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}