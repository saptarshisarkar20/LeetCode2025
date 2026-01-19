class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        int tk = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                ans.insert(0, Character.toUpperCase(s.charAt(i)));
                tk++;
                if (i != 0 && tk == k) {
                    ans.insert(0, "-");
                    tk = 0;
                }
            }
        }
        if (ans.length()>0 && ans.charAt(0) == '-')
            return ans.substring(1);
        return ans.toString();
    }
}