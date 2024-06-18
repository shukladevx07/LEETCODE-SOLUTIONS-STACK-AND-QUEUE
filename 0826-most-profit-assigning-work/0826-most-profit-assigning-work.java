class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n1 = difficulty.length;
        int n2 = worker.length;
        int sum = 0;

        for (int i = 0; i < n2; i++) {
            int largest = 0;
            for (int j = 0; j < n1; j++) {
                if (worker[i] >= difficulty[j]) {
                    largest = Math.max(largest, profit[j]);
                }
            }
            sum += largest;
        }
        return sum;
    }
}
