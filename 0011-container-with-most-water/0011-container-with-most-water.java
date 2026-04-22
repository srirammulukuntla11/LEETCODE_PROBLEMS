class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = n - 1;
        while(left < right)
        {
            int min = Math.min(height[left],height[right]);
            int len = right - left;
            int curArea = min*len;
            maxArea = Math.max(curArea,maxArea);
            if(height[left]<height[right])  left++;
            else right--;
        }
        return maxArea;
    }
}