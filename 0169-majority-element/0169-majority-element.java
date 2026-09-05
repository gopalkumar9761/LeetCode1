class Solution {
    public int majorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;

        for(int i=0; i<nums.length; i++) {
            if(count==0) {
                candidate = nums[i];
                count=1;
            }
            else if(candidate==nums[i]) {
                count++;
            }
            else {
                count--;
            }
        }

        int actualCount = 0;
        for(int i=0; i<nums.length; i++) {
            if(candidate==nums[i]) {
                actualCount++;
            }
        }
        if(actualCount > nums.length/2) {
            return candidate;
        }
        return -1;
    }
}