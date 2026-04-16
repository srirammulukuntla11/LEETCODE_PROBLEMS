import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int zeroCount = 0;
        int totalProduct = 1;


        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                totalProduct *= nums[i];
            }
        }
        if (zeroCount > 1) {
            Arrays.fill(result, 0);
        } 
        else if (zeroCount == 1) {
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    result[i] = totalProduct;
                } else {
                    result[i] = 0;
                }
            }
        } 
        else {
            for (int i = 0; i < n; i++) {
                result[i] = totalProduct / nums[i];
            }
        }

        return result;
    }
}