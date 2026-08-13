class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // Total sum must be divisible by 3
        if (sum % 3 != 0) {
            return false;
        }

        int target = sum / 3;
        int count = 0;
        int curSum = 0;

        for (int i = 0; i < n; i++) {
            curSum += arr[i];

            if (curSum == target) {
                count++;
                curSum = 0;
            }

            // We found 3 equal-sum parts
            if (count == 3) {
                return true;
            }
        }

        return false;
    }
}