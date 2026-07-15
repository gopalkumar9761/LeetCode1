class Solution {
    public int threeSumClosest(int[] nums, int target) {

     
        int n = nums.length;
        if (nums.length <= 2)
            return -1;

        Arrays.sort(nums);
        int res = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int st = i + 1;
            int en = n - 1;

            while (st < en) {
                int sum = nums[st] + nums[en] + nums[i];

                if (Math.abs((target - sum)) < diff) {
                    res = sum;
                    System.out.println(diff);
                    System.out.println(sum);
                    diff = Math.abs(target - sum);
                    System.out.println("new diff" + diff);
                    // while (st < n - 1 && nums[st] == nums[st + 1]) {
                    //     st++;
                    // }

                    // while (en > 0 && nums[en] == nums[en - 1]) {
                    //     en--;
                    // }

                    // st++;
                    // en--;
                } 
                if (sum > target) {
                    en--;
                } else {
                    st++;
                }
            }
        }
        return res;
    }
}
