class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        n--;
        // combination 1;
        int x = nums[n] - nums[2];

        // comb 2
        int y = nums[n - 2] - nums[0];

        //comb 3
        int z = nums[n - 1] - nums[1];

        return Math.min(Math.min(x, y), z);

    }
}