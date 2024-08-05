class Solution {
   public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    if (n == 0) return 0;
    if (n == 1) return cost[0];

    int first = cost[0];
    int second = cost[1];

    for (int i = 2; i < n; i++) {
        int current = cost[i] + Math.min(first, second);
        first = second;
        second = current;
    }

    return Math.min(first, second);
}


}
