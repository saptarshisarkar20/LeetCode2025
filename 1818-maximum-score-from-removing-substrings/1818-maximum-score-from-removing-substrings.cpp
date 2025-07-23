class Solution {
public:
    // string getMatches(string s, string x) {
    //     stack<char> st;
    //     char c1 = x[0], c2 = x[1];

    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s[i];
    //         if (!st.empty()) {
    //             if (c == c2 && st.top() == c1) {
    //                 // cout<<"pop"<<st.top()<<endl;
    //                 st.pop();
    //             } else {
    //                 st.push(c);
    //                 // cout<<c<<endl;
    //             }
    //         } else {
    //             st.push(c);
    //             // cout<<c<<endl;
    //         }
    //     }

    //     string ss = "";
    //     while (!st.empty()) {
    //         ss = (st.top() + ss);
    //         st.pop();
    //     }
    //     return ss;
    // }


    string getMatches(string s, string x) {
        string st;
        char c1 = x[0], c2 = x[1];

        for (int i = 0; i < s.length(); i++) {
            char c = s[i];
            if (st.length()>0) {
                char t = st[st.length()-1];
                if (c == c2 && t == c1) {
                    // cout<<"pop"<<st.top()<<endl;
                    st.pop_back();
                } else {
                    st+=c;
                    // cout<<c<<endl;
                }
            } else {
                st+=c;
                // cout<<c<<endl;
            }
        }

        
        return st;
    }

    int maximumGain(string s, int x, int y) {
        string xs = "ab", ys = "ba";
        int n = s.length(), ans = 0;
        if (x > y) {
            string res = getMatches(s, xs);
            ans += ((n - res.length()) / 2) * x;
            n = res.length();
            res = getMatches(res, ys);
            ans += ((n - res.length()) / 2) * y;
        } else {
            string res = getMatches(s, ys);
            ans += ((n - res.length()) / 2) * y;
            n = res.length();
            res = getMatches(res, xs);
            ans += ((n - res.length()) / 2) * x;
        }
        return ans;
    }
};