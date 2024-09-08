class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder str = new StringBuilder(); // Use StringBuilder instead of String
        
        // Build a new string with only alphanumeric characters
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) { // Check for alphanumeric characters
                str.append(s.charAt(i)); // Efficiently append to StringBuilder
            }
        }
        
        int left = 0;
        int right = str.length() - 1;
        
        // Check if the string is a palindrome
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
