class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // Use Prefix Max & Suffix Min technique
        
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int i=0;

        for(int j=0; j<nums.length; j++) {
            max = Math.max(nums[j], max);
            pref[j]=max;    
        }

        for(int l=nums.length-1; l>=0; l--) {
            min = Math.min(nums[l], min);
            suff[l] = min;
        }
        for(int m=0; m<nums.length; m++) {
            int stable = pref[m] - suff[m];
            
            if(stable <= k) {
                return m;
            }
        }
        return -1;
    }
}