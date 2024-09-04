class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int c = 0;
        
        for (int i = 0; i < n; i++) {
            int product = 1;  // Changed name for clarity
            for (int j = i; j < n; j++) {
                product *= nums[j];  // Multiply the product with the current element
                
                if (product < k) {
                    c++;
                } else {
                    // Break out of the loop if the product reaches or exceeds k
                    break;  // Key change to optimize the brute-force logic
                }
            }
        }
        
        return c;
    }
}
