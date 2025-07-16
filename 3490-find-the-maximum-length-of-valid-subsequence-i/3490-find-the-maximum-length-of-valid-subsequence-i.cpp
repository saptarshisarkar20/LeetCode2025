class Solution {
public:
    int comb_max;

    void findOddEven(vector<int>& nums, int yo) {
        int len = 0;

        // for (auto it : nums)
        //     cout << it;

        for (int i = 0; i < nums.size(); i++) {
            // cout<<" > "<<yo;
            if (nums[i] == yo) {
                // cout<<"yes";
                len++;
                yo = (1 - yo);
            }
        }

        // cout << " -- " << len << endl;

        comb_max = max(comb_max, len);
    }

    int maximumLength(vector<int>& nums) {

        int even = 0, odd = 0;
        comb_max = 0;

        for (int i = 0; i < nums.size(); i++) {
            nums[i] = (nums[i] & 1);

            nums[i] == 1 ? odd++ : even++;
        }

        findOddEven(nums, 0);
        findOddEven(nums, 1);

        return max({odd, even, comb_max});
    }
};