class Solution {
    public int rob(int[] nums) {
        // Create a dp array initialized to -1 to store results of subproblems
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = -1;
        }
        // Start the recursion from the first house
        return robHouse(nums, 0, dp);
    }

    private int robHouse(int[] nums, int currentIndex, int[] dp) {
        // Base case: If the current index is out of bounds, return 0
        if (currentIndex >= nums.length) {
            return 0;
        }

        // Check if we have already solved this subproblem
        if (dp[currentIndex] != -1) {
            return dp[currentIndex];
        }

        // Option 1: Rob the current house and skip the next house
        int robCurrent = nums[currentIndex] + robHouse(nums, currentIndex + 2, dp);

        // Option 2: Skip the current house and move to the next one
        int skipCurrent = robHouse(nums, currentIndex + 1, dp);

        // Store the result of the current subproblem in the dp array
        dp[currentIndex] = Math.max(robCurrent, skipCurrent);

        // Return the result for the current index
        return dp[currentIndex];
    }
}
