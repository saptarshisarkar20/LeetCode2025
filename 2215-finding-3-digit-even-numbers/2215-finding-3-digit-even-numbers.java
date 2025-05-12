class Solution {
    public int[] findEvenNumbers(int[] digits) {

        int[] mp = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        List<Integer> ans = new ArrayList<>();

        for (int it : digits) {
            mp[it] += 1;
        }

        for (int i = 100; i < 1000; i+=2) {
            int a = (i / 100); //first digit
            int b = (i / 10) % 10; //second digit
            int c = (i % 10); // third digit

            int[] temp = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            temp[a] += 1;
            temp[b] += 1;
            temp[c] += 1;

            boolean flag = true;
            for (int j = 0; j < 10; j++) {
                if (temp[j] > mp[j]) {
                    flag = false;
                    break;
                }

            }
            if (flag)
                ans.add(i);

        }

        return ans.stream().mapToInt(Integer::intValue).toArray();

    }
}