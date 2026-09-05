class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] pref=new int[nums.length];
        int[] suff=new int[nums.length];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        
        for(int j=0; j<nums.length; j++) {
            max = Math.max(max, nums[j]);
            pref[j] = max;
        }
        
        for(int m=nums.length-1; m>=0; m--) {
            min = Math.min(min, nums[m]);
            suff[m] = min;
        }

        for(int l=0; l<nums.length; l++) {
            int inst = pref[l] - suff[l];
            if(inst<=k){
                return l;
            }
        }
        return -1;
    }
}