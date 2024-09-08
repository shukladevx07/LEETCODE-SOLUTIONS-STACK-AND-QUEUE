class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;
        
        // Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }
        
        // Iterate through the array and check if the left sum equals the right sum
        for (int i = 0; i < nums.length; i++) {
            // Right sum is totalSum - leftSum - nums[i]
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            // Update left sum to include nums[i]
            leftSum += nums[i];
        }
        
        return -1; // No pivot index found
    }
}
