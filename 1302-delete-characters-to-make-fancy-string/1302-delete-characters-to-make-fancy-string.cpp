class Solution {
public:
    string makeFancyString(string s) {
        char curr = '0';

        int i = 0, cnt = 0;

        while (i < s.length()) {
            if (s[i] != curr) {
                cnt = 1;
                curr = s[i];
                i++;
            } else {
                if (cnt >= 2) {
                    int t = i + 1, cc = 1;
                    while (s[t] == curr) {
                        cc++;
                        t++;
                    }
                    s.erase(i, cc);
                } else {
                    cnt++;
                    i++;
                }
            }
        }
        return s;
    }
};