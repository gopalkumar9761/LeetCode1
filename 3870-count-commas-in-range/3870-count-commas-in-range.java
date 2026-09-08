class Solution {
    public int countCommas(int n) {
        long hel = 1000;
        int comas=0;
        if(n >= hel) {
            for(long i=hel; i<=n; i=i*1000) {
                comas += (n - i + 1);
            }
            return comas;
        }

        return 0;
        
    }
}