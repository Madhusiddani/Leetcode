class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] ans = new int[n];
        int l=0;
        int r=n-1;
        int p=n-1;
        while(l<=r){
            int lsq=nums[l]*nums[l];
            int rsq=nums[r]*nums[r];
            if(lsq>rsq){
                ans[p]=lsq;
                l++;
            }else{
                ans[p]=rsq;
                r--;
            }
            p--;
        }
      return ans;
    }
    
}