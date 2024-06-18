class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int rob1 = 0; // Maximum money robbed up to the previous house
        int rob2 = 0; // Maximum money robbed up to the current house

        for (int i = 0; i < n; i++) {
            int newRob = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = newRob;
        }

        return rob2;
    }
}
