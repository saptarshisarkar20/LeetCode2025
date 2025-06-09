class Solution {
public:
    vector<vector<int>> ans;

    void getSubsets(vector<int>& nums, int ind, vector<int>& ds) {
        ans.push_back(ds);
        for (int i = ind; i < nums.size(); i++) {
            if (i != ind && nums[i] == nums[i - 1])
                continue;
            ds.push_back(nums[i]);
            getSubsets(nums, i + 1,  ds);
            ds.pop_back();
        }
    }

    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<int> temp;
        sort(nums.begin(), nums.end());
        getSubsets(nums, 0, temp);

        return ans;
    }
};