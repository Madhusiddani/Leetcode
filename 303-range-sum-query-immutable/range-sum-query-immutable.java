class NumArray {
    private int[] nums;
    private int[] block;
    private int blockSize;
    private int n;

    public NumArray(int[] nums) {
         this.nums = nums;
        this.n = nums.length;
        this.blockSize = (int) (Math.sqrt(n));
        int totalBlocks = (n + blockSize - 1) / blockSize;
        this.block = new int[totalBlocks];

        for(int i = 0; i < n; i++){
            block[i / blockSize] += nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        int ans = 0;

        // Left Part
        while(left % blockSize != 0 && left <= right && left != 0){
            ans += nums[left++];
        }

        // Middle part
        while(left + blockSize - 1 <= right){
            ans += block[left / blockSize];
            left += blockSize;
        }

        // Right part
        while(left <= right){
            ans += nums[left++];
        }

        return ans;
    }
}