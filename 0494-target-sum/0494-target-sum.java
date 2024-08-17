class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for (int num : nums) sum += num;
        if (Math.abs(target) > sum) return 0 ;

        Integer[][] dp = new Integer[nums.length][2 * sum + 1];

        return helper(nums, nums.length - 1, target + sum, dp, sum);
    }

    private int helper(int[] nums, int n, int target, Integer[][] dp, int sum) {
        if (target < 0 || target >= dp[0].length) {
            return 0;
        }

        if (n == 0) {
            int ways=0;
            if (nums[0] == target - sum) ways += 1;
            if (nums[0] == -target + sum) ways += 1;
            return ways;
        }

        if (dp[n][target] != null) {
            return dp[n][target];
        }

        int add= helper(nums, n - 1, target - nums[n], dp, sum);
        int subtract= helper(nums, n - 1, target + nums[n], dp, sum);

        dp[n][target] = add + subtract;
        return dp[n][target];
    }
}
