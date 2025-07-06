class FindSumPairs {
public:
    vector<int> n1, n2;
    map<int, int> m1, m2;

    FindSumPairs(vector<int>& nums1, vector<int>& nums2) {
        n1 = nums1;
        n2 = nums2;

        for (auto it : n1)
            m1[it]++;
        for (auto it : n2)
            m2[it]++;
    }

    void add(int ind, int val) {
        int t = n2[ind] + val;
        if (m2[n2[ind]] > 0)
            m2[n2[ind]]--;

        n2[ind] = t;
        m2[t]++;
    }

    int count(int tot) {

        int ans = 0;

        for (auto it : m1) {
            int t = tot - it.first;
            if (m2[t] > 0) {
                ans += it.second * m2[t];
            }
        }

        return ans;
    }
};

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs* obj = new FindSumPairs(nums1, nums2);
 * obj->add(index,val);
 * int param_2 = obj->count(tot);
 */