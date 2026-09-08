class Solution {
    public void moveZeroes(int[] nums) {
       int first_non_zero = 0;
       for(int i = 0 ;i < nums.length;i++)
       {
         if(nums[i] != 0)
         {
            first_non_zero = i;
            break;
         }

       }
       int left = -1;
       for(int i = first_non_zero;i<nums.length;i++)
       {
            if(nums[i] != 0)
            {
                left++;
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
            }
       }

    }
}