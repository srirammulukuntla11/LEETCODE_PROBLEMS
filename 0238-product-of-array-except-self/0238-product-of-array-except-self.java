import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] preProd = new int[n];
        preProd[0] = 1;
        int[] postPro = new int[n];
        postPro[n-1] = 1;
        int leftProduct = 1;
        int rightProduct = 1;
        for(int i = 1;i<=n-1;i++)
        {
            preProd[i] = leftProduct*nums[i-1];
            leftProduct*=nums[i-1];
            postPro[n-i-1] = rightProduct*nums[n-i-1+1];
            rightProduct*=nums[n-i-1+1];
        }
        for(int i = 0;i<n;i++)
        {
            result[i] = preProd[i]*postPro[i];
        }
        return result;
    }
}