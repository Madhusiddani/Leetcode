class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l=1;
        int r=k;
          int p_sum=0;
        int maxSum=0;
        for(int i=0;i<k;i++){
           p_sum += nums[i];

        }
           maxSum = p_sum;
           while(r<nums.length){
                p_sum = p_sum - nums[l - 1] + nums[r];
            maxSum = Math.max(maxSum, p_sum );
            l++;
            r++;
        }

       return (double) maxSum / k;
    }
}


