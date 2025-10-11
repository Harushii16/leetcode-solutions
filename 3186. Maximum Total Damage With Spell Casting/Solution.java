import java.util.*;

public class Solution {
    public long maximumTotalDamage(int[] power) {
        // Step 1: Count frequency of each spell power
        Map<Integer, Long> countMap = new HashMap<>();
        for (int p : power) {
            countMap.put(p, countMap.getOrDefault(p, 0L) + 1);
        }

        // Step 2: Sort unique power values
        List<Integer> uniquePowers = new ArrayList<>(countMap.keySet());
        Collections.sort(uniquePowers);
        int n = uniquePowers.size();

        // Step 3: Precompute next index for each power using binary search
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            int curr = uniquePowers.get(i);
            int low = i + 1, high = n;
            // find first index where value > curr + 2
            while (low < high) {
                int mid = (low + high) / 2;
                if (uniquePowers.get(mid) > curr + 2) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            next[i] = low;
        }

        // Step 4: DP from right to left
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            long skip = dp[i + 1]; // Option 1: skip this power
            long take = uniquePowers.get(i) * countMap.get(uniquePowers.get(i)); // gain if taken
            if (next[i] < n) take += dp[next[i]]; // add future valid damage
            dp[i] = Math.max(skip, take);
        }

        // Step 5: Answer is dp[0]
        return dp[0];
    }

    // For quick testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] power = {1, 1, 3, 4};
        System.out.println(sol.maximumTotalDamage(power)); // Output: 6
    }
}
