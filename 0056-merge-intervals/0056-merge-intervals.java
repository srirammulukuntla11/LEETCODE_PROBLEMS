import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Edge case
        if (intervals.length == 0) return new int[0][0];

        // 1️⃣ Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();

        // 2️⃣ Traverse intervals
        for (int i = 0; i < intervals.length; i++) {

            // If ans is empty OR no overlap
            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(intervals[i]);
            }
            // Overlapping case
            else {
                ans.get(ans.size() - 1)[1] =
                        Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            }
        }

        // 3️⃣ Convert List to array (required by LeetCode)
        return ans.toArray(new int[ans.size()][]);
    }
}
