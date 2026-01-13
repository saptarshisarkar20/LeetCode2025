class Solution {
    public int[] findErrorNums(int[] nums) {
        int x, y;
        int[] ans = new int[2];
        int[] vis = new int[nums.length+1];

        // for (int i = 0; i < nums.length+1; i++) {
        //     vis[i] = 0;
        // }
        for (int num : nums) {
            vis[num]++;
        }
        for (int i = 0; i < nums.length+1; i++) {
            if (vis[i] == 0) ans[1] = i ;
            if (vis[i] == 2) ans[0] = i ;
        }
        return ans;        
    }
}