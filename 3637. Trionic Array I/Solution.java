class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false; // Need at least 4 elements
    
        int i = 0;
        // 1) First strictly increasing segment
        while (i < n - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        // must be non-zero length, and cannot finish array
        if (i == 0 || i >= n - 2) return false;
    
        // 2) Strictly decreasing segment
        int j = i;
        while (j < n - 1 && nums[j] > nums[j + 1]) {
            j++;
        }
        // must have moved, and cannot finish array
        if (j == i || j >= n - 1) return false;
    
        // 3) Last strictly increasing segment
        while (j < n - 1 && nums[j] < nums[j + 1]) {
            j++;
        }
    
        return j == n - 1;
    }
}
