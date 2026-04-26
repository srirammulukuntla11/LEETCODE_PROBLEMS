class Solution {
    // public boolean comp(String s1,String s2)
    // {
    //     return s1.length()<s2.length();
    // }
    public boolean checkPossible(String s1,String s2)
    {
        if(s1.length()!=s2.length()+1) return false;
        int first = 0;
        int second = 0;
        while(first<s1.length())
        {
            if(second<s2.length() && s1.charAt(first) == s2.charAt(second))
            {
                first++;
                second++;
            }
            else
            {
                first++;
            }
        }
        if(first == s1.length() && second == s2.length()) return true;
        return false;
    }
    public int longestStrChain(String[] arr) {
        int n = arr.length;
Arrays.sort(arr, (a, b) -> a.length() - b.length());
        int[] dp = new int[n];        // length of LIS ending at 

        Arrays.fill(dp, 1);

        // for (int i = 0; i < n; i++) {
        //     hash[i] = i;  // initialize self
        // }

        // DP logic
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (checkPossible(arr[i],arr[prev]) && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                
                }
            }
        }

        // find max length index
        int maxi = 0;
      

        for (int i = 0; i < n; i++) {
            if (dp[i] > maxi) {
                maxi = dp[i];
                
            }
        }
        return maxi;

    }
}