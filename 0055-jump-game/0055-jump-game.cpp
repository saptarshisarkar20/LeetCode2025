class Solution {
public:
    bool canJump(vector<int>& nums) {
        int reach = nums[0];

        for (int i = 1; i < nums.size(); i++) {
            if (reach < i)
                return false;

            reach = max(reach, i + nums[i]);
        }

        if (reach >= nums.size() - 1)
            return true;

        return false;
    }
};