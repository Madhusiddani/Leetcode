class Solution {
    public int mySqrt(int x) {
        if(x==0 ||x==1){
            return x;
        }
        int l = 0;
        int r = x;
        int mid = -1;
        while(l<=r){
             mid =l + (r-l)/2;
            long sq=(long)mid*mid;
            if(sq > x){
                r = mid-1;
            }else if(sq==(long)x){
                return mid;
            }else{
               l=mid+1;
            }
        }
        return r;
    }
}