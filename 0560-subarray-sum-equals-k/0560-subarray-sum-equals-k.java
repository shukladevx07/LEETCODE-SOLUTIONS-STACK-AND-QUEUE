import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Initialize a hashmap to store cumulative sums and their frequencies
        HashMap<Integer, Integer> cumulativeSumMap = new HashMap<>();
        cumulativeSumMap.put(0, 1); // Base case: there's one way to have a sum of 0 (using no elements)

        int cumulativeSum = 0;
        int count = 0;

        // Iterate over the array
        for (int num : nums) {
            cumulativeSum += num;

            // Check if there is a previous cumulative sum that matches cumulativeSum - k
            if (cumulativeSumMap.containsKey(cumulativeSum - k)) {
                count += cumulativeSumMap.get(cumulativeSum - k);
            }

            // Update the cumulative sum frequency map
            cumulativeSumMap.put(cumulativeSum, cumulativeSumMap.getOrDefault(cumulativeSum, 0) + 1);
        }

        return count;
    }
}
