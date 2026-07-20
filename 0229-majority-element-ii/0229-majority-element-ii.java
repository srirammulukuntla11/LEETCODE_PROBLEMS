class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans= new ArrayList<>();
        int cnt1=0,el1=Integer.MIN_VALUE,cnt2=0,el2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(cnt1==0 && nums[i]!=el2)
            {
                cnt1=1;
                el1=nums[i];
            }
            else if(cnt2==0 && nums[i]!=el1)
            {
                cnt2=1;
                el2=nums[i];
            }
            else if(nums[i]==el1)
            {
                cnt1++;
            }
            else if(nums[i]==el2)
            {
                cnt2++;
            }
            else
            {
                cnt1--;
                cnt2--;
            }
        }
        int cn1=0,cn2=0;
        for(int i=0;i<nums.length;i++)
        {
            if(el1==nums[i]) cn1++;
            if(el2==nums[i]) cn2++;
        }
        int min=(nums.length)/3;
        if(cn1>min) ans.add(el1);
        if(cn2>min) ans.add(el2);
        return ans;
        
    }
}