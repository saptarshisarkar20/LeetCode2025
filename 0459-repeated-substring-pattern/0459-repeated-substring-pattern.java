class Solution {

    private boolean checkRestString(String pattern, String s){
        int x = pattern.length();
        for( int i=0; i<s.length(); i+=x){
            if(i+x > s.length()) return false;

            if(!pattern.equals(s.substring(i, i+x))) return false;
        }
        return true;
    }

    public boolean repeatedSubstringPattern(String s) {
        boolean ans = false; 
        for( int i=1; i<=s.length()/2; i++){
            //   System.out.println(i+ ") ^ - left = "+ s.substring(0, i) + " | right = "+ s.substring(i, 2*i));
            if(s.substring(0, i).equals(s.substring(i, 2*i))){
                // System.out.println("left = "+ s.substring(0, i) + " | right = "+ s.substring(i, 2*i));
                ans = ans | checkRestString(s.substring(0,i), s);
                if(ans) return ans;
            }
        }
        return ans;        
    }
}