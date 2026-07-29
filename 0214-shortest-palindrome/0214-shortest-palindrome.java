class Solution {

    // Function to build LPS array (KMP preprocessing)
    private void buildLPS(int[] lps, String s) {
        int i = 0;   // length of previous longest prefix suffix
        int j = 1;   // current index

        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                lps[j] = i;
                j++;
            } else {
                if (i == 0) {
                    lps[j] = 0;
                    j++;
                } else {
                    i = lps[i - 1];
                }
            }
        }
    }

    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        // Combine string
        String combined = s + "#" + rev;

        int[] lps = new int[combined.length()];
        buildLPS(lps, combined);

        // Length of longest palindromic prefix
        int len = lps[combined.length() - 1];

        // Remaining part
        String remaining = s.substring(len);

        // Reverse remaining and add in front
        return new StringBuilder(remaining).reverse().toString() + s;
    }
}
