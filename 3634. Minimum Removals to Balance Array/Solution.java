class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, longest = 0, n = nums.length;
        
        for (int right = 0; right < n; right++) {
            while (nums[right] > 1L * nums[left] * k) {
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        
        return n - longest;
    }
}
