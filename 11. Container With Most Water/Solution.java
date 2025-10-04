class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Width between the two lines
            int width = right - left;
            // Height is limited by the smaller line
            int h = Math.min(height[left], height[right]);
            // Current area
            int area = width * h;
            // Update max area
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
