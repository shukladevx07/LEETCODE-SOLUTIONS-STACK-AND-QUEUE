import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Priority Queue to store projects sorted by their capital requirements
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // Priority Queue to store projects sorted by their profits
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        // Add all projects to the minHeap
        for (int i = 0; i < profits.length; i++) {
            minHeap.offer(new int[]{capital[i], profits[i]});
        }

        // Perform up to k projects
        for (int i = 0; i < k; i++) {
            // Move all projects that can be started with current capital to maxHeap
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
                maxHeap.offer(minHeap.poll());
            }

            // If no projects can be started, break the loop
            if (maxHeap.isEmpty()) {
                break;
            }

            // Select the most profitable project
            w += maxHeap.poll()[1];
        }

        return w;
    }
}
