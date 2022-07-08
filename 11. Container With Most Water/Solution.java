class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max_area = 0;
        while (i < j) {
            max_area = Math.max(max_area, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;

            } else {
                j--;

            }

        }

        return max_area;
    }
}