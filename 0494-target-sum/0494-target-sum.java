class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, nums.length - 1, target);
    }

    private int helper(int[] nums, int n, int target) {
        if (n == 0) {
            int ways=0;
            if (nums[0] == target) ways += 1;
            if (nums[0] == -target) ways += 1;
            return ways;
        }
        int add= helper(nums, n - 1, target - nums[n]);
        int subtract= helper(nums, n - 1, target + nums[n]);
        return add + subtract;
    }
}
