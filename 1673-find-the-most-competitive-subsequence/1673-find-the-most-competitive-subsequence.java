class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] stack = new int[k];
        int top = -1; // index to manage the stack

        for (int i = 0; i < n; i++) {
            // if the current element is smaller than the top of the stack and we have enough elements left
            while (top >= 0 && stack[top] > nums[i] && top + (n - i) >= k) {
                top--;
            }
            // if there is still space in the stack, add the current element
            if (top + 1 < k) {
                stack[++top] = nums[i];
            }
        }
        return stack;
    }
}
