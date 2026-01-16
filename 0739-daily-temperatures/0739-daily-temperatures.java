class Pair<K, V> {
    public K first;
    public V second;

    Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
}


class Solution {
    public int[] dailyTemperatures(int[] temp) {
             // next warmer day return duration
//        Input:  [73,74,75,71,69,72,76,73]
//        Output: [ 1, 1, 4, 2, 1, 1, 0, 0]
        int[] ans = new int[temp.length];
        
//        Pair<Integer, Integer> pp = new Pair<>(1, 2);
        Stack<Pair<Integer, Integer>> st = new Stack<>();

        for (int i = temp.length-1; i >= 0; i--){
            ans[i] = 0;
            if(!st.empty() && st.peek().first > temp[i] ){
                ans[i] = st.peek().second - i;
            }
            else{
                while(!st.empty() && st.peek().first <= temp[i]){
                    st.pop();
                }
                ans[i] = st.empty() ? 0 : st.peek().second - i;
            }
            st.push(new Pair<>(temp[i], i));
        }
        return ans;
  
    }
}