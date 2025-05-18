class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int ans = 0;
        int curr = INT_MAX;

        for (int it : prices) {
            curr = min(curr, it);
            ans = max(ans, it - curr);
        }

        return ans;
    }
};