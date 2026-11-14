class Solution {

    private int checkAns(int ans, int curr) {
        if (curr > 0)
            ans = Math.min(curr, ans);
        return ans;
    }

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE, curr = 0;
        for (int i = 0; i < l && i < nums.size(); i++)
            curr += nums.get(i);

        int left = 0, right = l, diff = r - l;
        ans = checkAns(ans, curr);
        while (left < nums.size()) {
            int temp = 0;

            for (int j = right; j < right + diff && j < nums.size(); j++) {
                temp += nums.get(j);
                ans = checkAns(ans, curr + temp);
            }
            if (right < nums.size())
                curr = (curr - nums.get(left) + nums.get(right));
            left += 1;
            right += 1;
            ans = checkAns(ans, curr);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}