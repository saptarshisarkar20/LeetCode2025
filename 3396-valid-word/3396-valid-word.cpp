class Solution {
public:
    bool isVol(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        return false;
    }

    bool isCons(char c) {
        int temp = (c - 'a');
        int t = (c-'A');
        if ((temp >= 0 && temp <= 26) || (t >= 0 && t<= 26))
            return true;
        return false;
    }

    bool isDigi(char c) {
        int temp = ('a' - c);
        if (temp >= 40 && temp <= 49)
            return true;
        return false;
    }

    bool checkVC(string s) {

        bool fhv = false, fhc = false;

        for (int i = 0; i < s.length(); i++) {
            if (isVol(s[i])) {
                fhv = true;
            } else if (isCons(s[i])) {
                fhc = true;
            } else if (!isDigi(s[i])) {
                return false;
            }
        }

        return (fhv && fhc);
    }

    bool isValid(string word) {

        if (word.length() < 3)
            return false;

        // cout << ('a' - '1') << " | " << ('a' - '0');

        return checkVC(word);
    }
};