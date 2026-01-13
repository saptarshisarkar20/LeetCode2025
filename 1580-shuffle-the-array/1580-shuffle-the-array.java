class Solution {
    public int[] shuffle(int[] nums, int n) {
        int l = 0, r = n, ind = 0;
        int[] ans = new int[2 * n];

        while (r < 2 * n) {
            ans[ind++] = nums[l++];
            ans[ind++] = nums[r++];
        }
        return ans;        
    }
}