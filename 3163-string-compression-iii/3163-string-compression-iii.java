class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int i = 0;

        while (i < word.length()) {
            char c = word.charAt(i);
            int count = 0;

            // Count up to 9 repetitions of the character c
            while (i < word.length() && word.charAt(i) == c && count < 9) {
                i++;
                count++;
            }

            // Append the count and the character to the result
            comp.append(count).append(c);
        }

        return comp.toString();
    }
}
