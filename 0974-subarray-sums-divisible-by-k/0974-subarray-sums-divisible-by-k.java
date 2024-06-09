import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Edge case check
        if (nums == null) {
            return 0;
        }

        // Map to store the frequency of prefix sums modulo k
        Map<Integer, Integer> prefixModCount = new HashMap<>();
        // Initialize with 0 as a prefix sum, because a prefix sum of 0 modulo k
        // implies the subarray sum is directly divisible by k
        prefixModCount.put(0, 1);

        int sum = 0;
        int count = 0;

        // Traverse through the array
        for (int num : nums) {
            // Calculate the cumulative sum
            sum += num;

            // Calculate the modulus of the current sum with k
            int mod = sum % k;

            // Adjust negative mod value to be positive (if any)
            if (mod < 0) {
                mod += k;
            }

            // If the mod value has been seen before, it means there are subarrays
            // which sum up to be divisible by k
            if (prefixModCount.containsKey(mod)) {
                count += prefixModCount.get(mod);
            }

            // Update the frequency of the current mod value in the map
            prefixModCount.put(mod, prefixModCount.getOrDefault(mod, 0) + 1);
        }

        return count;
    }
}
