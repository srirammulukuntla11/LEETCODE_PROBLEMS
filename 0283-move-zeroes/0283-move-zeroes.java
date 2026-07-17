class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIndex = -1;
        int n = nums.length;
        for(int i = 0;i<n;i++)
        {
            if(nums[i] == 0)
            {
                zeroIndex = i;
                break;
            }
        }
        if(zeroIndex == -1) return;
        for(int j = zeroIndex+1;j<n;j++)
        {
            if(nums[j]!=0)
            {
                int temp = nums[j];
                nums[j] = nums[zeroIndex];
                nums[zeroIndex] = temp;
                zeroIndex++;
            }
        }

    }
}