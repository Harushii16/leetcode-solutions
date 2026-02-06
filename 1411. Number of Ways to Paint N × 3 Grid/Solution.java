class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007;
        long abc = 6, aba = 6;

        for (int i = 2; i <= n; i++) {
            long newAbc = (abc * 2 + aba * 2) % MOD;
            long newAba = (abc * 2 + aba * 3) % MOD;
            abc = newAbc;
            aba = newAba;
        }
        return (int)((abc + aba) % MOD);
    }
}
