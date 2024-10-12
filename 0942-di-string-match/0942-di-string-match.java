class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] result = new int[n + 1];
        int low = 0;
        int high = n;
        
        // Iterate over the string to assign values
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                result[i] = low;
                low++;
            } else {
                result[i] = high;
                high--;
            }
        }
        
        // Assign the remaining value to the last position
        result[n] = low;  // low and high are equal here
        
        return result;
    }
}
