class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < groups.length; i++) {
            int curr = -1;
            List<Integer> l = new ArrayList<>();
            for (int j = i; j < groups.length; j++) {
                if (curr != groups[j]) {
                    l.add(j);
                    curr = groups[j];
                }
            }
            if (l.size() > ans.size()) {
                ans = new ArrayList<>();
                for (int it : l) {
                    ans.add(words[it]);
                }

            }

        }

        return ans;

    }
}
