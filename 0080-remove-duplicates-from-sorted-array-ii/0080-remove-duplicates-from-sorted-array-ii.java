class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return n;

        int curr_ele = nums[0];
        int curr_cnt = 1;

        int k = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] == curr_ele) {
                curr_cnt++;
            } else {
                curr_ele = nums[i];
                curr_cnt = 1;
            }

            if (curr_cnt < 3) {
                nums[k] = nums[i];
                k++;
            }

        }

        return k;

    }
}