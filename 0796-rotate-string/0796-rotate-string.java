class Solution {
    public boolean rotateString(String s, String goal) {

        int n = s.length();
        if (s.equals(goal))
            return true;

        

        for (int i = 1; i < n; i++) {
            if (s.substring(i, n).equals(goal.substring(0, n - i)) &&
                    s.substring(0, i).equals(goal.substring(n - i, n)))
                return true;
        }
        return false;
    }
}