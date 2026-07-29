class Solution {

    
    private void buildLPS(int[] lps, String s) {
        int i = 0;  
        int j = 1;   

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

        
        String combined = s + "#" + rev;

        int[] lps = new int[combined.length()];
        buildLPS(lps, combined);

      
        int len = lps[combined.length() - 1];

      
        String remaining = s.substring(len);

        
        return new StringBuilder(remaining).reverse().toString() + s;
    }
}
