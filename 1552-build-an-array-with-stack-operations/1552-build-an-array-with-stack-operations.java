class Solution {
    public List<String> buildArray(int[] target, int n) {
                int ind = 0, curr = 1;
        List<String> ans = new ArrayList<>();
        while (ind < target.length && curr <= n) {
            if (curr == target[ind]) {
                ans.add("Push");
                ind++;
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
            curr++;
        }
        return ans;
    }
}