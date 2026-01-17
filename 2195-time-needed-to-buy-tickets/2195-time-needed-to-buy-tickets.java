class Solution {

    public int timeRequiredToBuy(int[] tkt, int k) {
        int ans = 0;
        Queue<Pair<Integer, Boolean>> q = new ArrayDeque<>();
        int temp_k = k;
        for (int t : tkt) {
            boolean flag = (temp_k == 0);
            q.add(new Pair<>(t, flag));
            temp_k--;
        }

        boolean done = false;
        while (!q.isEmpty() && !done) {
            int temp = q.peek().val;
            boolean tg = q.peek().ind;
            q.remove();

            if (tg && temp == 1) return ++ans;

            if (temp != 1) {
                q.add(new Pair<>(temp - 1, tg));
            }
            ans++;
        }
        return ans;


    }

    private static class Pair<V, K> {
        public V val;
        public K ind;

        Pair(V v, K k) {
            this.val = v;
            this.ind = k;
        }
    }
}