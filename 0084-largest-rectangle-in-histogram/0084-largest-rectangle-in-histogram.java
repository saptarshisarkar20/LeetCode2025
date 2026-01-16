class Solution {

    private static class Pair<K, V> {
        public K val;
        public V ind;

        Pair(K val, V ind) {
            this.val = val;
            this.ind = ind;
        }
    }

    // next smaller element
    private void rightSmall(int[] rs, int[] h) {
        int n = h.length;
        Stack<Pair<Integer, Integer>> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (!st.empty() && st.peek().val < h[i]) {
                rs[i] = st.peek().ind;
            } else {
                while (!st.empty() && st.peek().val >= h[i]) {
                    st.pop();
                }
                rs[i] = st.empty() ? n : st.peek().ind;
            }
            if (st.empty() || st.peek().val != h[i])
                st.push(new Pair<>(h[i], i));
        }
    }

    // previous smaller element
    private void leftSmall(int[] rs, int[] h) {
        int n = h.length;
        Stack<Pair<Integer, Integer>> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!st.empty() && st.peek().val < h[i]) {
                rs[i] = st.peek().ind;
            } else {
                while (!st.empty() && st.peek().val >= h[i]) {
                    st.pop();
                }
                rs[i] = st.empty() ? -1 : st.peek().ind;
            }
            if (st.empty() || st.peek().val != h[i])
                st.push(new Pair<>(h[i], i));
        }
    }




    public int largestRectangleArea(int[] h) {
        int[] rs = new int[h.length];
        int[] ls = new int[h.length];

        rightSmall(rs, h);
        leftSmall(ls, h);
        // for (int i : ls)
        //     System.out.print(" | " + i);
        // System.out.println();
        // for (int i : rs)
        //     System.out.print(" | " + i);
        // System.out.println();

        // System.out.println();

        int ans = 0;

        for (int i = 0; i < h.length; i++) {

            // int curr_area = 0;
            // if (rs[i] == ls[i])
            //     curr_area = h[i];
            // else if (rs[i] == i)
            //     curr_area = h[i] * (i - ls[i]);
            // else if (ls[i] == i)
            //     curr_area = h[i] * (rs[i] - i);
            // else
            int curr_area = h[i] * (rs[i] - ls[i] - 1);

            // System.out.println(
            //         " l-> " + ls[i] + " i-> " + i + " r-> " + rs[i] + " h[i] -> " + h[i] + " | area = " + curr_area);
            ans = Math.max(ans, curr_area);
        }

        return ans;

        // return 10;
    }
}
