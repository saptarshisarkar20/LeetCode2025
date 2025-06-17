class Solution {
    static final int MOD = 1_000_000_007;
    static long[] factorial = new long[100_005];
    static long[] inverseFactorial = new long[100_005];
    static boolean initialized = false;

    public int countGoodArrays(int n, int m, int k) {
        if (!initialized) {
            precomputeFactorials(100_000);
            initialized = true;
        }

        long combinations = factorial[n - 1] * inverseFactorial[k] % MOD * inverseFactorial[n - 1 - k] % MOD;
        long differentParts = powMod(m - 1, n - 1 - k);
        long total = m * combinations % MOD * differentParts % MOD;

        return (int) total;
    }

    void precomputeFactorials(int maxN) {
        factorial[0] = 1;
        for (int i = 1; i <= maxN; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }

        inverseFactorial[maxN] = powMod(factorial[maxN], MOD - 2);
        for (int i = maxN - 1; i >= 0; i--) {
            inverseFactorial[i] = inverseFactorial[i + 1] * (i + 1) % MOD;
        }
    }

    long powMod(long base, int exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}
