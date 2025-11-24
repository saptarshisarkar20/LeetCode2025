class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {
        vector<bool> ans; 

        int po = 0;
        int curr = 0;

        for(int i=0; i<nums.size(); i++){
            curr = ((2*curr) + nums[i])%5;
            // cout<<curr<<" | ";
            ans.push_back(curr%5==0);
            po++;
        }
        return ans;
    }
};