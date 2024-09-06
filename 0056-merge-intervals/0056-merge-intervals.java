import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals; // No need to merge if there's only one or no interval.
        }
        
        // Step 1: Sort the intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Step 2: Initialize a result list to store merged intervals
        ArrayList<int[]> result = new ArrayList<>();
        
        // Step 3: Add the first interval to the result
        int[] currentInterval = intervals[0];
        result.add(currentInterval);
        
        // Step 4: Iterate over the intervals and merge them if needed
        for (int[] interval : intervals) {
            // Current interval is stored as last element of result
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            
            if (nextStart <= currentEnd) { // Overlapping intervals
                // Merge the intervals by updating the end of the current interval
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, add the new interval to the result
                currentInterval = interval;
                result.add(currentInterval);
            }
        }
        
        // Step 5: Convert result to a 2D array and return
        return result.toArray(new int[result.size()][]);
    }
}
