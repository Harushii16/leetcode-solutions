import java.util.*;

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;
        int prev = 0;  // length of previous increasing run
        int cur = 0;   // length of current increasing run

        for (int i = 0; i < n; i++) {
            cur++;

            // Check if this is the end of a strictly increasing run
            if (i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                // Case 1: Split current run into two halves
                ans = Math.max(ans, cur / 2);

                // Case 2: Combine previous and current runs (adjacent increasing)
                ans = Math.max(ans, Math.min(prev, cur));

                // Move current run to previous and reset cur
                prev = cur;
                cur = 0;
            }
        }
        return ans;
    }
}
