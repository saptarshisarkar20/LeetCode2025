class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
               boolean[] vis = new boolean[nums.length + 1];
//        Arrays.fill(vis, false);
        for (int i : nums) {
            vis[i] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < nums.length + 1; i++) {
            if (!vis[i]) ans.add(i);
        }

        return ans; 
    }
}