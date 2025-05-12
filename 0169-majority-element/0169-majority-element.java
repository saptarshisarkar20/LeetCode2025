class Solution {
    public int majorityElement(int[] nums) {

        int curr_ele = nums[0];
        int curr_cnt = 1;

        for (int i = 1; i < nums.length; i++) {
            if (curr_cnt == 0) {
                curr_ele = nums[i];
            }

            if (nums[i] == curr_ele) {
                curr_cnt += 1;
            } else {
                curr_cnt -= 1;
            }

        }

        return curr_ele;

    }
}