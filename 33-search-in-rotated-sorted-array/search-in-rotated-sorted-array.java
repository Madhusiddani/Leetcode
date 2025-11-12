class Solution {
    public int search(int[] nums, int target) {
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == target) {
        //         return i;
        //     } 
        // }
        // return -1;

        int l=0;
        int r=nums.length-1;
        while(l<=r){
            if(nums[l]==target){
                return l;
            }
            if(nums[r]==target){
                return r;
            }else{
                l++;
                r--;
            }
        }
        return -1;
    }
}