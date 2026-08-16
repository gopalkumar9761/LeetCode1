class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) {
            return 0;
        }
        int left=0;
        int right=1;
        int j=0;
        while(right<nums.length) {
          if(nums[j]!=nums[right]) {
             j++;
             nums[j]=nums[right];
          }
          right++;
        }
        return j+1;
    }
}