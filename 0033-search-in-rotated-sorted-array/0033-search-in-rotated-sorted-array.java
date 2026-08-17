class Solution {
    public int search(int[] nums, int target) {
       int first = 0;
       int last = nums.length - 1;
       
       while(first <= last) {
           int mid = first + (last - first) / 2;
           
           if (nums[mid] == target) {
               return mid;
           }
           
           // Left half is sorted
           if (nums[first] <= nums[mid]) {
               if (nums[first] <= target && target < nums[mid]) {
                   last = mid - 1;
               } else {
                   first = mid + 1;
               }
           } 
           // Right half is sorted
           else {
               if (nums[mid] < target && target <= nums[last]) {
                   first = mid + 1;
               } else {
                   last = mid - 1;
               }
           }
       }
       return -1;
    }
}