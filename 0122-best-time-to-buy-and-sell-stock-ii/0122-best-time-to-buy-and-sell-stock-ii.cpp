class Solution {
public:
    int maxProfit(vector<int>& pcs) {
        int ans = 0;

        for (int i = 1; i < pcs.size(); i++) {
            int t = pcs[i] - pcs[i - 1];
            if (t > 0)
                ans += t;
        }
        return ans;
    }
};