class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0; // Counters for $5 and $10 bills

        for (int bill : bills) {
            if (bill == 5) {
                // Increase count of $5 bills
                five++;
            } else if (bill == 10) {
                // Customer pays with $10, need one $5 as change
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else if (bill == 20) {
                // Customer pays with $20, need $15 as change
                if (ten > 0 && five > 0) {
                    // Prefer giving one $10 and one $5 as change
                    ten--;
                    five--;
                } else if (five >= 3) {
                    // Otherwise, need three $5 bills
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
