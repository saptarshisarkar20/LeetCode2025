class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return ans;

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> (nums1[a.i] + nums2[a.j]) - (nums1[b.i] + nums2[b.j]));

        // Initialize heap with first column
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new Node(i, 0));
        }

        while (k-- > 0 && !pq.isEmpty()) {
            Node cur = pq.poll();
            ans.add(List.of(nums1[cur.i], nums2[cur.j]));

            if (cur.j + 1 < nums2.length) {
                pq.offer(new Node(cur.i, cur.j + 1));
            }
        }

        return ans;
    }

    private static class Node {
        int i, j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}