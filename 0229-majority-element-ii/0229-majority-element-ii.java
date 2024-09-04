import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int n1 = n / 3;
        Arrays.sort(nums);
        int c = 1;  // Start with 1 since first element is counted
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                c++;
            } else {
                if (c > n1) {
                    list.add(nums[i - 1]);
                }
                c = 1;  // Reset count for the new number
            }
        }
        
        // Check for the last element group
        if (c > n1) {
            list.add(nums[n - 1]);
        }
        
        return list;
    }
}
