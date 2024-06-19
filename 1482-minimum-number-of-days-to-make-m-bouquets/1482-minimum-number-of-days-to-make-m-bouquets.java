class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // Check if it's possible to make m bouquets
        if (bloomDay.length < (long) m * k)
            return -1;

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        // Find the minimum and maximum days in bloomDay
        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        // Binary search to find the minimum day
        while (left < right) {
            int mid = (left + right) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    // Helper function to check if we can make m bouquets in 'days' days
    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0;
        int flowers = 0;

        for (int day : bloomDay) {
            if (day <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}
