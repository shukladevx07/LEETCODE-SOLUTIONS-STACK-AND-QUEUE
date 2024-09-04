class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long c = 0; // Use 'long' for c to avoid integer overflow
        for (int i = 0; i < n; i++) {
            long sum = 0; // Reset sum for each new starting index
            for (int j = i; j < n; j++) {
                sum += nums[j]; // Accumulate sum of the current subarray
                long score = sum * (j - i + 1); // Calculate score as sum * length
                if (score < k) {
                    c++; // Count the subarray if the score is less than k
                } else {
                    break; // Exit the inner loop early if the score >= k
                }
            }
        }
        return c;
    }
}
