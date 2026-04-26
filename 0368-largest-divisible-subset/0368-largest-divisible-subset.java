class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
      
        int n = arr.length;

        int[] dp = new int[n];        // length of LIS ending at i
        int[] hash = new int[n];      // to track previous index

        Arrays.fill(dp, 1);
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            hash[i] = i;  // initialize self
        }

        // DP logic
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[i]%arr[prev] == 0 && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }
        }

        // find max length index
        int maxi = 0;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] > maxi) {
                maxi = dp[i];
                lastIndex = i;
            }
        }

        // reconstruct LIS
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(arr[lastIndex]);

        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            lis.add(arr[lastIndex]);
        }

        // reverse to get correct order
        Collections.reverse(lis);

        return lis;
    }
}