class Solution {
    private List<String> ans;

    private void makeLCP(String s, int ind, String temp) {
        if (ind >= s.length()) {
            ans.add(temp);
            return;
        }

        if (Character.isLetter(s.charAt(ind))) {
            makeLCP(s, ind + 1, temp + Character.toLowerCase(s.charAt(ind)));
            makeLCP(s, ind + 1, temp + Character.toUpperCase(s.charAt(ind)));
        } else {
            makeLCP(s, ind + 1, temp + s.charAt(ind));
        }
    }


    public List<String> letterCasePermutation(String s) {
        ans = new ArrayList<>();
        makeLCP(s, 0, "");
        return ans;
    }
}