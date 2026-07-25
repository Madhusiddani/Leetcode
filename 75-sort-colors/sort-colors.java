class Solution {
    public void sortColors(int[] nums) {
       int l=0;
       int curr=0;
       int r=nums.length-1;
       while(curr<=r){
        if(nums[curr]==0){
            int temp=nums[l];
            nums[l]=nums[curr];
            nums[curr]=temp;
            l++;
            curr++;
        }
        else if(nums[curr]==1){
            curr++;
        }else{
            int temp=nums[curr];
            nums[curr]=nums[r];
            nums[r]=temp;
            r--;
        }
       } 
    }
}