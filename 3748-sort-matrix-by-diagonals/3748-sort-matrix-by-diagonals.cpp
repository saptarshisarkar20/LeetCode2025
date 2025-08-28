class Solution {
public:
    vector<vector<int>> sortMatrix(vector<vector<int>>& grid) {
        vector<vector<int>> v;
        int n = grid.size();
        int flip = 1;
        for (int i = 0; i < n; i++) {
            vector<int> t;
            int r = i, c = 0;
            while (r < n && c < n) {
                t.push_back(grid[r][c]);
                r++;
                c++;
            }

            sort(t.begin(), t.end(), greater<int>());

            int rr = i, cc = 0, ind = 0;
            while (rr < n && cc < n) {
                grid[rr][cc] = t[ind];
                rr++;
                cc++;
                ind++;
            }
        }

        for (int i = 1; i < n; i++) {
            vector<int> t;
            int r = 0, c = i;
            while (r < n && c < n) {
                t.push_back(grid[r][c]);
                r++;
                c++;
            }

            sort(t.begin(), t.end());

            flip = 1 - flip;
            int rr = 0, cc = i, ind = 0;
            while (rr < n && cc < n) {
                grid[rr][cc] = t[ind];
                rr++;
                cc++;
                ind++;
            }
        }

        return grid;
    }
};