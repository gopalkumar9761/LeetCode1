class Solution {
    public long countCommas(long n) {
        long comas=0;
        if(n>=1000) {
        for(long i=1000; i<=n; i=i*1000) {
            comas += n - i + 1;
           }
           return comas;
        }
        return 0;
    }
}