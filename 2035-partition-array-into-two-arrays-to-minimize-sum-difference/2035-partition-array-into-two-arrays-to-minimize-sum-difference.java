import java.util.*;

class Solution {

    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int half = n / 2;

        int[] left = Arrays.copyOfRange(nums, 0, half);
        int[] right = Arrays.copyOfRange(nums, half, n);

        // Generate subset sums grouped by size
        List<List<Integer>> leftSums = generateSubsetSums(left);
        List<List<Integer>> rightSums = generateSubsetSums(right);

        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int target = totalSum / 2;
        int ans = Integer.MAX_VALUE;

        // Try all possible splits
        for (int k = 0; k <= half; k++) {

            List<Integer> lList = leftSums.get(k);
            List<Integer> rList = rightSums.get(half - k);

            Collections.sort(rList);

            for (int s1 : lList) {
                int need = target - s1;

                int idx = Collections.binarySearch(rList, need);
                if (idx < 0) idx = -idx - 1;

                // Check closest values
                if (idx < rList.size()) {
                    int s2 = rList.get(idx);
                    int curr = s1 + s2;
                    ans = Math.min(ans, Math.abs(totalSum - 2 * curr));
                }

                if (idx > 0) {
                    int s2 = rList.get(idx - 1);
                    int curr = s1 + s2;
                    ans = Math.min(ans, Math.abs(totalSum - 2 * curr));
                }
            }
        }

        return ans;
    }

    // Generate subset sums grouped by subset size
    private List<List<Integer>> generateSubsetSums(int[] arr) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            result.add(new ArrayList<>());
        }

        int total = 1 << n;

        for (int mask = 0; mask < total; mask++) {
            int sum = 0;
            int count = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    count++;
                }
            }

            result.get(count).add(sum);
        }

        return result;
    }
}