class Solution {
    public int searchInsert(int[] nums, int target) {
        int first = 0;
        int last = nums.length;

        while (first < last) {
            int mid = first + (last - first) / 2;
            if(nums[mid] >= target) {
                last = mid;
            }
            else {
                first = mid + 1;
            }
        }
        return first;
    }
}