class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l=0;
        int r=0;
        int blank=0;
        for(char c:moves.toCharArray()){
            if(c=='L'){
                l++;
            }else if(c=='R'){
                r++;
            }else{
                blank++;
            }
        }
        return Math.abs(l-r)+blank;
    }
}