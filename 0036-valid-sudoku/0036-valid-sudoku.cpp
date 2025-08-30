class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {

        // check row wise
        for (int i = 0; i < 9; i++) {
            vector<int> v(10, 0);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.')
                    v[board[i][j] - '0']++;
            }
            for (auto it : v)
                if (it > 1)
                    return false;
        }

        // column wise
        for (int i = 0; i < 9; i++) {
            vector<int> v(10, 0);
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.')
                    v[board[j][i] - '0']++;
            }
            for (auto it : v)
                if (it > 1)
                    return false;
        }

        // grid wise
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                vector<int> v(10, 0);
                for (int r = i; r < i + 3; r++)
                    for (int c = j; c < j + 3; c++)
                        if (board[r][c] != '.') {
                            v[board[r][c] - '0']++;
                            // cout << board[r][c] << " | ";
                        }
                // cout << endl;
                for (auto it : v)
                    if (it > 1)
                        return false;
            }
        }

        return true;
    }
};