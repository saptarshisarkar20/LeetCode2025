class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();

        int curr = 1;
        List<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < groups.length; i++) {
            if (curr != groups[i]) {
                l1.add(i);
                curr = groups[i];
            }
        }

        curr = 0;
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < groups.length; i++) {
            if (curr != groups[i]) {
                l2.add(i);
                curr = groups[i];
            }
        }

        if (l1.size() > l2.size()) {
            for (int it : l1) {
                ans.add(words[it]);
            }
        } else {
            for (int it : l2) {
                ans.add(words[it]);
            }
        }

        return ans;

    }
}