class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] count = new int[26];

        // Count characters of s
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        // Try to match target as much as possible
        for (int i = 0; i < n; i++) {

            int t = target.charAt(i) - 'a';

            // First try to put the same character as target[i]
            if (count[t] > 0) {
                ans.append((char) ('a' + t));
                count[t]--;
                continue;
            }

            // Same character is not available.
            // Find the smallest character greater than target[i]
            for (int ch = t + 1; ch < 26; ch++) {
                if (count[ch] > 0) {

                    ans.append((char) ('a' + ch));
                    count[ch]--;

                    // Put remaining characters in sorted order
                    for (int c = 0; c < 26; c++) {
                        while (count[c] > 0) {
                            ans.append((char) ('a' + c));
                            count[c]--;
                        }
                    }

                    return ans.toString();
                }
            }

            // Cannot make a greater permutation at this position,
            // so we need to backtrack.
            break;
        }

        /*
         * We reached here when the prefix was equal to target
         * but couldn't continue.
         *
         * Backtrack and change one previous character to
         * the smallest possible character greater than target.
         */
        for (int i = ans.length() - 1; i >= 0; i--) {

            // Return the character at position i to count
            char old = ans.charAt(i);
            count[old - 'a']++;

            int t = target.charAt(i) - 'a';

            // Find smallest character greater than target[i]
            for (int ch = t + 1; ch < 26; ch++) {

                if (count[ch] > 0) {

                    StringBuilder result = new StringBuilder();

                    // Keep prefix before i
                    result.append(ans.substring(0, i));

                    // Put greater character
                    result.append((char) ('a' + ch));
                    count[ch]--;

                    // Append remaining characters smallest first
                    for (int c = 0; c < 26; c++) {
                        while (count[c] > 0) {
                            result.append((char) ('a' + c));
                            count[c]--;
                        }
                    }

                    return result.toString();
                }
            }
        }

        // No permutation greater than target exists
        return "";
    }
}