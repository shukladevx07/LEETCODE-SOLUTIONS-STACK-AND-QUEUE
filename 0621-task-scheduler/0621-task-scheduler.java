import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Calculate the frequency of each task
        int[] taskCounts = new int[26];
        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }
        
        // Step 2: Sort the task frequencies in descending order
        Arrays.sort(taskCounts);
        
        // Step 3: Find the maximum frequency
        int maxFreq = taskCounts[25];
        int maxCount = 1;
        
        // Count how many tasks have the maximum frequency
        for (int i = 24; i >= 0; i--) {
            if (taskCounts[i] == maxFreq) {
                maxCount++;
            } else {
                break;
            }
        }
        
        // Step 4: Calculate the minimum intervals required
        int partCount = maxFreq - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - (maxFreq * maxCount);
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length + idles;
    }
}
