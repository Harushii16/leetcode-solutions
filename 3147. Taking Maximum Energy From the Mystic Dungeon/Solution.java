class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int ans = Integer.MIN_VALUE;

        // For each remainder (0 to k-1)
        for (int r = 0; r < k; r++) {
            int curr = 0;

            // Find last index in this chain (r + t*k <= n-1)
            int start = r + ((n - 1 - r) / k) * k;

            // Traverse backwards by k
            for (int i = start; i >= 0; i -= k) {
                curr += energy[i];         // Add energy of this index
                ans = Math.max(ans, curr); // Update max
            }
        }

        return ans;
    }
}
