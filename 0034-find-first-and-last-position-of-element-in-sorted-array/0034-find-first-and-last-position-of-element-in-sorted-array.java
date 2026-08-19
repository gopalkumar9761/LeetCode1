class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }
    
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
                firstIndex = midIndex;
                lastIndex = midIndex - 1; 
            }
        }
        return firstIndex;
    }

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
                lastIndexFound = midIndex;
                startIndex = midIndex + 1; 
            }
        }
        return lastIndexFound;
    }
}