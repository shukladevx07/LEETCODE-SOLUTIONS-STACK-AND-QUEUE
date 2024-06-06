import java.util.Arrays;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);  // Sort the array
        boolean[] used = new boolean[n];  // Track used cards

        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;  // Skip already used cards
            }
            int count = 1;
            used[i] = true;
            int prev = hand[i];
            for (int j = i + 1; j < n && count < groupSize; j++) {
                if (!used[j] && hand[j] == prev + 1) {
                    used[j] = true;
                    prev = hand[j];
                    count++;
                }
            }
            if (count < groupSize) {
                return false;
            }
        }

        return true;
    }
}
