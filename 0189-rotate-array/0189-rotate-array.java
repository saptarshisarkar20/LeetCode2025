class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = (k % n);
        if (k == 0)
            return;

        int i = 0, j = n - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i += 1;
            j -= 1;
        }
        
        i=k;
        j=n-1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i += 1;
            j -= 1;
        }


        i=0;
        j=k-1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i += 1;
            j -= 1;
        }


        return;

    }
}