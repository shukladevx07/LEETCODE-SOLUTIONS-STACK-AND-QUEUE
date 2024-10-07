import java.util.HashMap;

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        
        // Count the occurrences of each character
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int palindromeLength = 0;
        boolean hasOddCount = false;
        
        // Calculate the maximum possible length of the palindrome
        for (int count : map.values()) {
            if (count % 2 == 0) {
                palindromeLength += count;  // Add even counts fully
            } else {
                palindromeLength += count - 1;  // Add the largest even part
                hasOddCount = true;  // Mark that there's at least one odd count
            }
        }
        
        // If there's at least one character with an odd count, add 1 for the center
        if (hasOddCount) {
            palindromeLength += 1;
        }
        
        return palindromeLength;
    }
}
