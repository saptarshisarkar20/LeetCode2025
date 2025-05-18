class Solution {
public:
    int jump(vector<int>& nums) {
        if (nums.size() < 2)
            return 0;

        int reach = nums[0], cnt = 1;
        int i = 1;
        while (i < nums.size()) {
            if (reach >= nums.size() - 1)
                return cnt;
            int curr_reach = reach;
            int curr_ind = i;
            for (int j = curr_reach; j >= i; j--) {
                if (reach < j + nums[j]) {
                    reach = j + nums[j];
                    curr_ind = j;
                }
            }
            cnt++;
            i = curr_ind + 1;
        }
        return cnt;
    }
};