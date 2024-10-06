import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency array for s1 and for the current window in s2
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Fill the frequency array for s1
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // Now, slide the window over s2
        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }

            // Slide the window: remove the leftmost character and add the next one
            windowFreq[s2.charAt(i) - 'a']++;  // Add new character to the window
            windowFreq[s2.charAt(i - s1.length()) - 'a']--;  // Remove the leftmost character
        }

        // Final check for the last window
        return Arrays.equals(s1Freq, windowFreq);
    }
}
