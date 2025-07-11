class Solution {
public:
    int solve(int n, int k) {
        if (n == 1 && k == 1)
            return 0;

        int len = pow(2, n - 1);
        int mid = len / 2;

        if (k <= mid) {
            return solve(n - 1, k);
        }
        return !solve(n - 1, k - mid);
    }

    int kthGrammar(int n, int k) { return solve(n, k); }
};