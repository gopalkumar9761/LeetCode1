class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;
        int prevValidIdx = -1;
        int invalidIdx = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                invalidIdx = i;
            } else if (nums[i] >= left) {
                prevValidIdx = i;
            }

            if (prevValidIdx > invalidIdx) {
                count += (prevValidIdx - invalidIdx);
            }
        }

        return count;
    }
}