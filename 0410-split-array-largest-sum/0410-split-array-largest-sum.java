class Solution {
    public int cntStudents(int arr[],int pages)
    {
        int stu=1,stuPages=0;
        for(int i=0;i<arr.length;i++)
        {
            if((stuPages+arr[i])<=pages)
            {
                stuPages+=arr[i];
            }
            else
            {
                stu++;
                stuPages=arr[i];
            }
        }
        return stu;

    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        if(k>n) return -1;
        int low=Arrays.stream(nums).max().getAsInt();
        int high=Arrays.stream(nums).sum();
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int cntStu=cntStudents(nums,mid);
            if(cntStu>k)
            {
                low=mid+1;

            }
            else
            {
                high=mid-1;
            }
        }
        return low;
    }
}