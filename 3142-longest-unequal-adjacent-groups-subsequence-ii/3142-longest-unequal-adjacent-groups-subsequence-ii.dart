class Solution {
 

List<String> getWordsInLongestSubsequence(
    List<String> words, List<int> groups) {
  List<String> ans = [];
  if (words.length == 1) return words;

  Map<String, List<String>> memo = {};

  List<String> _helper(int i, int lastGroup, String lastWord) {
    if (i >= words.length) {
      return [];
    }

    // Build memoization key
    String key = '$i|$lastGroup|$lastWord';
    if (memo.containsKey(key)) return memo[key]!;

    List<String> take = [];
    if (words[i].length == lastWord.length &&
        hammingDistanceAllowed(lastWord, words[i]) &&
        lastGroup != groups[i]) {
      take = [words[i], ..._helper(i + 1, groups[i], words[i])];
    }

    List<String> skip = _helper(i + 1, lastGroup, lastWord);

    List<String> result = take.length > skip.length ? take : skip;
    memo[key] = result;
    return result;
  }

  for (int i = 0; i < words.length - 1; i++) {
    List<String> res = [words[i], ..._helper(i + 1, groups[i], words[i])];
    if (ans.length < res.length) ans = res;
  }

  return ans;
}

bool hammingDistanceAllowed(String w1, String w2) {
  int dist = 0;
  for (int i = 0; i < w1.length; i++) {
    if (w1[i] != w2[i]) dist++;
  }
  return dist == 1;
}

}