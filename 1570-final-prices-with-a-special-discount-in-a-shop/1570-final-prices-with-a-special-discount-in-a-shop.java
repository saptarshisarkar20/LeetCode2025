class Solution {
public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        // ans[prices.length - 1] = prices[prices.length - 1];
        Stack<Integer> st = new Stack<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            if (!st.isEmpty() && st.peek() < prices[i]) {
                ans[i] = prices[i] - st.peek();
                st.push(prices[i]);
            } else {
                while (!st.isEmpty() && st.peek() > prices[i]) {
                    st.pop();
                }
                ans[i] = !st.isEmpty() ? prices[i] - st.peek() : prices[i];
                st.push(prices[i]);

            }

        }
        return ans;

    }
}