public class Solution {
    public int myAtoi(String s) {
        int index = 0, sign = 1, total = 0;
        // Check if empty string
        if(s.length() == 0) return 0;

        // Remove whitespaces
        while(index < s.length() && s.charAt(index) == ' ')
            index++;

        // Get the sign
        if(index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')){
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // Convert to number and avoid overflow
        while(index < s.length()){
            int digit = s.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            // Check for overflow
            if(Integer.MAX_VALUE/10 < total || 
                Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }
}