class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Check if the total sum is odd
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int target = totalSum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];
        return canFindSubset(nums, 0, target, dp);
    }
    
    private boolean canFindSubset(int[] nums, int index, int target, Boolean[][] dp) {
        // Base cases
        if (target == 0) return true; // Found a subset with the required sum
        if (target < 0 || index >= nums.length) return false; // No valid subset or out of bounds
        if (dp[index][target] != null) return dp[index][target]; // Use cached result
        
        // Recursive case: include the current number or not
        boolean take = canFindSubset(nums, index + 1, target - nums[index], dp);
        boolean notTake = canFindSubset(nums, index + 1, target, dp);

        // Store result in memoization table before returning
        dp[index][target] = take || notTake;
        return dp[index][target];
    }
}
