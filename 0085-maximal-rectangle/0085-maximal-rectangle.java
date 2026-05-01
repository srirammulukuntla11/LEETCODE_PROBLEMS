import java.util.*;

class Solution {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int n = heights.length;
        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            while(!stk.isEmpty() && heights[stk.peek()] > heights[i]) {
                int element = stk.pop();
                int nse = i;
                int pse = stk.isEmpty() ? -1 : stk.peek();
                maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
            }
            stk.push(i);
        }

        while(!stk.isEmpty()) {
            int element = stk.pop();
            int nse = n;
            int pse = stk.isEmpty() ? -1 : stk.peek();
            maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[] height = new int[m];
        int maxArea = 0;

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < m; j++) {

                if(matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }

            int area = largestRectangleArea(height);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}