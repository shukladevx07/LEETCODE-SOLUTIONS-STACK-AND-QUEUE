import java.util.*;

class Solution {
    private int[] nums;
    private List<Integer>[] memo;  // Memoization cache for storing results

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        Arrays.sort(nums);  // Sort the array to ensure divisibility checks are coherent

        // Initialize memoization lists
        memo = new List[n];
        
        List<Integer> largestSubset = new ArrayList<>();
        
        // Find the largest subset using recursion and memoization
        for (int i = 0; i < n; i++) {
            List<Integer> subset = findLargestSubset(i);
            if (subset.size() > largestSubset.size()) {
                largestSubset = subset;
            }
        }
        
        return largestSubset;
    }
    
    private List<Integer> findLargestSubset(int index) {
        if (memo[index] != null) {
            return memo[index];
        }
        
        List<Integer> largestSubset = new ArrayList<>();
        largestSubset.add(nums[index]);  // Start with the current number itself

        // Recursively find the largest valid subset for previous numbers
        for (int previousIndex = 0; previousIndex < index; previousIndex++) {
            if (nums[index] % nums[previousIndex] == 0) {
                List<Integer> previousSubset = findLargestSubset(previousIndex);
                if (previousSubset.size() + 1 > largestSubset.size()) {
                    largestSubset = new ArrayList<>(previousSubset);  // Make a copy of previousSubset
                    largestSubset.add(nums[index]);
                }
            }
        }
        
        memo[index] = largestSubset;  // Store result in memo cache
        return largestSubset;
    }
}
