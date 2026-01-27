class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums2) {
            while (!s.isEmpty() && i > s.peek()) {
                hm.put(s.pop(),i);
            }
            s.add(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = hm.getOrDefault(nums1[i], -1);
        }
         return ans;
    }
}