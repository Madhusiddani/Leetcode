class Solution {
    public int search(int[] nums, int target) {
        // O(n) complexity linear search
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == target) {
        //         return i;
        //     } 
        // }
        // return -1;


// binary search with complexity O(n)
        // int l=0;
        // int r=nums.length-1;
        // while(l<=r){
        //     if(nums[l]==target){
        //         return l;
        //     }
        //     if(nums[r]==target){
        //         return r;
        //     }else{
        //         l++;
        //         r--;
        //     }
        // }
        // return -1;


        // Using pivot element to get complexity O(log n)

        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[l]<=nums[mid]){
                if(nums[l]<= target && target< nums[mid]){
                    r = mid -1;
                }else{
                    l = mid + 1;
                }
            }
            else{
                if(nums[mid]< target && target <= nums[r]){
                    l = mid+1;
                }else{
                    r = mid -1;
                }
            }
        } 
        return -1;
    }
}