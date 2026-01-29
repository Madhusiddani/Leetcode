class Solution {
    public int maxArea(int[] height) {
        int MaxArea = 0;
        int left = 0;
        int right = height.length -1;
        while(left<right){
            int curr_area = Math.min(height[left],height[right])*(right-left);
            MaxArea = Math.max(MaxArea,curr_area);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return MaxArea;
    }
}