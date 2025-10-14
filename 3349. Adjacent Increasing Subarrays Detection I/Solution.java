class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int cur = 1;   // current increasing run length
        int pre = 0;   // previous run length

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                cur++;
            } else {
                if (cur / 2 >= k || Math.min(pre, cur) >= k)
                    return true;
                pre = cur;
                cur = 1;
            }
        }

        if (cur / 2 >= k || Math.min(pre, cur) >= k)
            return true;

        return false;
    }
}
