class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // Only keep the current and previous row in memory
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        // Fill the DP array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            // Swap current and previous row references
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        // Reconstruct the shortest common supersequence
        StringBuilder ans = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                ans.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (prev[j] > curr[j - 1]) {
                ans.append(str1.charAt(i - 1));
                i--;
            } else {
                ans.append(str2.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters of str1 or str2
        while (i > 0) {
            ans.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            ans.append(str2.charAt(j - 1));
            j--;
        }

        // The sequence was constructed backwards, so reverse it
        return ans.reverse().toString();
    }
}
