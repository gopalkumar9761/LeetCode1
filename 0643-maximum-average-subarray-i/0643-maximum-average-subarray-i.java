class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double currSum = 0;
        for(int i=0; i<k; i++) {
            currSum += nums[i];
        }
        double maxSum = currSum;

        for(int i=1; i<=nums.length-k; i++) {
            currSum = currSum - nums[i-1] + nums[i+k-1];
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum/k;
    }
}