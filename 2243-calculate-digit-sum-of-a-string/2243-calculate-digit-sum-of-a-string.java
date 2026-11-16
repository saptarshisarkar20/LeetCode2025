class Solution {

    private String calSum(String s){
        // System.out.println("s -> "+ s);
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            ans += (s.charAt(i) - '0');
            // System.out.print(ans +" | ");
        }
        // System.out.println("************");
        return String.valueOf(ans);
    }

    public String digitSum(String s, int k) {
        String ans = s;

        while(ans.length() > k){
            StringBuilder curr = new StringBuilder();
            for( int i=0; i<ans.length();i+=k){
                curr.append(calSum(ans.substring(i, Math.min(i+k, ans.length()))));
                
            }
            ans = curr.toString();
        }
        return ans;
    }
}