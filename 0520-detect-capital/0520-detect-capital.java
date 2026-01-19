class Solution {

    private boolean isCapLetter(Character c) {
        return (c >= 'A' && c <= 'Z');
    }

    private boolean isCapString(String st, int l, int r) {
        if (r < l) return true;
        for (int i = l; i <= r; i++) {
            if (!isCapLetter(st.charAt(i))) return false;
        }
        return true;
    }

    private boolean isLowString(String st, int l, int r) {
        if (r < l) return true;
        for (int i = l; i <= r; i++) {
            if (isCapLetter(st.charAt(i))) return false;
        }
        return true;
    }


    public boolean detectCapitalUse(String word) {
        int n = word.length();

        if (isCapLetter(word.charAt(0))) {
            return isCapString(word, 0, n - 1) || isLowString(word, 1, n - 1);
        } else {
            return isLowString(word, 0, n - 1);
        }
        // return true;
    }
}