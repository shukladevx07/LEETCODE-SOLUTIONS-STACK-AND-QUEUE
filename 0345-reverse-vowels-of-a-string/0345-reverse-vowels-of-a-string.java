class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        char[] arr = s.toCharArray(); // Convert the string to a char array for easier manipulation
        
        // Move the pointers towards each other
        while (left < right) {
            // Move the left pointer to the next vowel
            while (left < right && !isVowel(arr[left])) {
                left++;
            }
            
            // Move the right pointer to the previous vowel
            while (left < right && !isVowel(arr[right])) {
                right--;
            }
            
            // Swap the vowels
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
        
        return new String(arr); // Convert the char array back to a string
    }

    // Helper method to check if a character is a vowel
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
