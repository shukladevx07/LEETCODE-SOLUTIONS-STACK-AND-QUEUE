class Solution {
    public int minLength(String s) {
        int n = s.length();
        int i = 0;
        
        // Continue the process as long as there are potential substrings to remove
        while (i < n - 1) {
            if (s.substring(i, i + 2).equals("AB") || s.substring(i, i + 2).equals("CD")) {
                // Remove the matched substring "AB" or "CD"
                s = s.substring(0, i) + s.substring(i + 2, n);
                n = s.length();  // Update the length of the string after removal
                i = 0;  // Start over to check from the beginning
            } else {
                i++;  // Move to the next character if no match is found
            }
        }
        
        return s.length();  // Return the length of the final string
    }
}
