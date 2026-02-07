
class Solution {
public:
    int minimumDeletions(string s)
    {
        vector<int> ac(s.length(), 0);
        vector<int> bc(s.length(), 0);

        int acnt = 0, bcnt = 0;

        for (int i = s.length()-1; i >= 0; i--)
        {
           
            ac[i] = acnt;
             if (s[i] == 'a')
                acnt++;
        }

        for (int i = 0; i < s.length(); i++)
        {
            
            bc[i] = bcnt;
            if (s[i] == 'b')
                bcnt++;
        }

        int ans = INT_MAX;

        for (int i = 0; i < s.length(); i++)
        {
            // cout<<"ind-"<<i<<" ac> "<<ac[i]<<" | bc> "<<bc[i]<<endl;
            ans = min(ans, ac[i] + bc[i]);
        }

        return ans;
    }
};