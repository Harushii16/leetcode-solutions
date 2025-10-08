import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            
            // Calculate minimum required potion strength
            long required = (success + spell - 1) / spell;  // ceil(success / spell)
            
            // Binary search for the first potion >= required
            int idx = lowerBound(potions, required);
            
            // Count of successful pairs
            res[i] = m - idx;
        }
        return res;
    }
    
    // Custom lowerBound implementation (like C++ lower_bound)
    private int lowerBound(int[] potions, long target) {
        int left = 0, right = potions.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
