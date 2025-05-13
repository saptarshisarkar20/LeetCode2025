class Solution {
  int lengthAfterTransformations(String s, int t) {
    const int MOD = 1000000007;
    List<int> cnt = List.filled(26, 0);

    // Count occurrences of each character in the string
    for (int i = 0; i < s.length; i++) {
      cnt[s.codeUnitAt(i) - 'a'.codeUnitAt(0)]++;
    }

    // Perform transformations
    for (int j = 0; j < t; j++) {
      List<int> tmp = List.filled(26, 0);
      for (int i = 0; i < 26; i++) {
        if (i == 25) {
          tmp[0] = (tmp[0] + cnt[i]) % MOD;
          tmp[1] = (tmp[1] + cnt[i]) % MOD;
        } else {
          tmp[i + 1] = (tmp[i + 1] + cnt[i]) % MOD;
        }
      }
      cnt = tmp;
    }

    // Calculate final length
    int len = 0;
    for (int c in cnt) {
      len = (len + c) % MOD;
    }

    return len;
  }
}