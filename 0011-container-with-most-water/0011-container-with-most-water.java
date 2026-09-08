class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right)
        {
            if(height[left] < height[right])
            {
                int len = right - left;
                maxArea = Math.max(maxArea,len*height[left]);
                left++;
            }
            else
            {
                int len = right - left;
                maxArea = Math.max(maxArea,len*height[right]);
                right--;
            }
        }
        return maxArea;
    }
}