class Solution {
    public int bestRotation(int[] nums) {
        final int n = nums.length;
        int[] rotate = new int[n];
        
        for (int i = 0; i < n; ++i) {
            rotate[(i - nums[i] + 1 + n) % n]--;
        }
        
        for (int i = 1; i < n; ++i) {
            rotate[i] += rotate[i - 1] + 1;
        }
        
        int mx = Integer.MIN_VALUE;
        int maxIndex = 0;
        
        for (int i = 0; i < n; ++i) {
            if (rotate[i] > mx) {
                mx = rotate[i];
                maxIndex = i;
            }
        }
        
        return maxIndex;
    }
}