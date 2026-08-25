public class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE; // Initialize to max value to find the minimum length
        while (j < nums.length) {
            sum += nums[j];
            j++;
            while (sum >= k) {
                minLen = Math.min(minLen, j - i);
                sum -= nums[i];
                i++;
            }
        }
        
        if (minLen == Integer.MAX_VALUE) {
            return 0;
        } 
        else {
            return minLen;
        }
    }
}