class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1, c2 = cost2, cb = costBoth, n1 = need1, n2 = need2;
        long ans = 0;

        if (cb > (c1 + c2)) {
            ans = c1 * n1 + c2 * n2;
        } else {
            long common = Math.min(n1, n2);

            ans = cb * common;

            long n1_remain = n1 - common;
            long n2_remain = n2 - common;

            if (n1_remain > 0) {
                ans += (n1_remain * Math.min(c1, cb));
            }
            if (n2_remain > 0) {
                ans += (n2_remain * Math.min(c2, cb));
            }

        }
        return ans;
    }
}