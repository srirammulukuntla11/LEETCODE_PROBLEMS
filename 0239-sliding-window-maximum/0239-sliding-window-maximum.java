import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> li = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {

            // remove indices outside window
            if(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // remove smaller elements
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // window reached size k
            if(i >= k - 1) {
                li.add(nums[dq.peekFirst()]);
            }
        }

        // convert list to array
        int[] ans = new int[li.size()];
        for(int i = 0; i < li.size(); i++) {
            ans[i] = li.get(i);
        }

        return ans;
    }
}