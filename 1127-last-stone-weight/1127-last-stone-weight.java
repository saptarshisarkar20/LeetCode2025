class Solution {
    public int lastStoneWeight(int[] stn) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int it : stn)
            pq.offer(it);

        while (!pq.isEmpty() && pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();

            int t = x - y;
            if (t != 0) {
                pq.offer(t);
            }
        }
        if (pq.isEmpty())
            return 0;
        return pq.poll();
    }
}