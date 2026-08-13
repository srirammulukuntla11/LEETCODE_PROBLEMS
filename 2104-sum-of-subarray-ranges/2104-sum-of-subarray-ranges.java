import java.util.*;

class Solution {

    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMin(nums);
    }

    private long sumSubarrayMin(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] > arr[i])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long count = (mid - left) * (long)(right - mid);
                sum += arr[mid] * count;
            }
            stack.push(i);
        }

        return sum;
    }

    private long sumSubarrayMax(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] < arr[i])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long count = (mid - left) * (long)(right - mid);
                sum += arr[mid] * count;
            }
            stack.push(i);
        }

        return sum;
    }
}