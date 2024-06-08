class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (helper(nums, i, j, k)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(int[] arr, int i, int j, int k) {
        int sum = 0;
        int count = 0;
        for (int index = i; index <= j; index++) {
            sum += arr[index];
            count++;
        }
        return sum % k == 0 && count >= 2;
    }
}
