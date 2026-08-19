class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }
    
    // 1. Sirf Pehli (First) Position dhundhne ke liye alag method
    private int findFirst(int[] nums, int target) {
        int startIndex = 0;
        int lastIndex = nums.length - 1;
        int firstIndex = -1;
        
        while (startIndex <= lastIndex) {
            int midIndex = startIndex + (lastIndex - startIndex) / 2;
            
            if (nums[midIndex] < target) {
                startIndex = midIndex + 1;
            } else if (nums[midIndex] > target) {
                lastIndex = midIndex - 1;
            } else {
                // Target mil gaya, par pehli position ke liye aur LEFT (peeche) dekho
                firstIndex = midIndex;
                lastIndex = midIndex - 1; 
            }
        }
        return firstIndex;
    }
    
    // 2. Sirf Aakhri (Last) Position dhundhne ke liye alag method
    private int findLast(int[] nums, int target) {
        int startIndex = 0;
        int lastIndex = nums.length - 1;
        int lastIndexFound = -1;
        
        while (startIndex <= lastIndex) {
            int midIndex = startIndex + (lastIndex - startIndex) / 2;
            
            if (nums[midIndex] < target) {
                startIndex = midIndex + 1;
            } else if (nums[midIndex] > target) {
                lastIndex = midIndex - 1;
            } else {
                // Target mil gaya, par aakhri position ke liye aur RIGHT (aage) dekho
                lastIndexFound = midIndex;
                startIndex = midIndex + 1; 
            }
        }
        return lastIndexFound;
    }
}