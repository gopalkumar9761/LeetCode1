class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] last = new long[26];
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long currentSum = 1;
            for (int i = 0; i < 26; i++) {
                currentSum = (currentSum + last[i]) % MOD;
            }
            last[idx] = currentSum;
        }
        
        long ans = 0;
        for (long count : last) {
            ans = (ans + count) % MOD;
        }
        
        return (int) ans;
    }
}