class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0) return 1;
        double half = helper(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.myPow(2.00000, 10)); // Output: 1024.00000
        System.out.println(solution.myPow(2.10000, 3));  // Output: 9.26100
        System.out.println(solution.myPow(2.00000, -2)); // Output: 0.25000
    }
}
