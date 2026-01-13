class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int curr = 0;

        for (int num : nums) {
            if (num == 1) curr++;
            else curr = 0;
            ans = Math.max(curr, ans);
        }
        return ans;            
        }
}