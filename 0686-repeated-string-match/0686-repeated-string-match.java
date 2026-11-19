class Solution {
    public int repeatedStringMatch(String a, String b) {
        int nb = b.length(), na = a.length();

        int t = nb / na;

        String s = a + a;
        while (t > 0) {
            s += a;
            t--;
        }
        int ans = -1;

        for (int i = 0; i < s.length() - nb; i++) {
            if (s.substring(i, i + nb).equals(b)) {
                int x = i + nb;
                ans = (x + na - 1) / na;
                break;
            }
        }
        return ans;
    }
}