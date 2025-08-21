class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
            int O=x;
            int R=0;
            while(x>0){
                int digit=x%10;
                R=R*10+digit;
                x=x/10;
            }
        return O == R;
    }
}