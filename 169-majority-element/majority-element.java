class Solution {
    public int majorityElement(int[] nums) {
        int MajorityElement = nums[0];
        int count=1;
        for(int index=1;index<nums.length;index++){
            if(nums[index]==MajorityElement){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                MajorityElement=nums[index];
                count=1;
            }
        }
        return MajorityElement;
    }
}