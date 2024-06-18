import java.util.Arrays;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;

        // Create an array of jobs with difficulty and profit
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // Sort jobs by difficulty
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        // Sort workers by their ability
        Arrays.sort(worker);

        int maxProfit = 0, bestProfit = 0, i = 0;
        for (int ability : worker) {
            // While the worker can complete the job, update the bestProfit
            while (i < n && ability >= jobs[i][0]) {
                bestProfit = Math.max(bestProfit, jobs[i][1]);
                i++;
            }
            // Add the best profit the worker can get to the total profit
            maxProfit += bestProfit;
        }

        return maxProfit;
    }
}
