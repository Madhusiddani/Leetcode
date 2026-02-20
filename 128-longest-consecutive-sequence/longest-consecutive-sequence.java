class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        int ans=1;
        if(nums.length==0){
            return 0;
        }
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(Integer j:set){
            int cnt=1;
            int x=j;
            if(!set.contains(j-1)){
                while(set.contains(x+1)){
                    cnt++;
                    x++;
                }
            }
            ans=Math.max(ans,cnt);
        }
        return ans;
    }
}