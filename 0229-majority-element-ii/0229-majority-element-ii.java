class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Integer candidate1 = null;
        Integer candidate2 = null;
        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (candidate1 != null && num == candidate1) {
                count1++;
            } else if (candidate2 != null && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        int actualCount1 = 0;
        int actualCount2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(candidate1 != null && nums[i] == candidate1) {
                actualCount1++;
            }
            else if(candidate2 != null && nums[i] == candidate2) {
                actualCount2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;

        if(candidate1 != null && actualCount1 > threshold) {
            result.add(candidate1);
        }
        if(candidate2 != null && actualCount2 > threshold) {
            result.add(candidate2);
        }

        return result;
    }
}