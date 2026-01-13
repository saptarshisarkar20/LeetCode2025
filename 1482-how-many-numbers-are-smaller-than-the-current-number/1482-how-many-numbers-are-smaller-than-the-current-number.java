class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] hp = new int[101];
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int num:nums){
            hp[num]++;
        }
        
        int curr = 0;
        for (int i = 0; i < 101; i++) {
            if(hp[i]>0){
                mp.put(i, curr);
                curr += hp[i];
            }
        }
            
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = mp.get(nums[i]);            
        }
        return ans;
    }
}