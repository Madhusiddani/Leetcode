// class Solution {
//     public List<String> buildArray(int[] target, int n) {
//        List<String> arr= new ArrayList<>();
//         List<Integer> stack=new ArrayList<>();
//         String var = "Push";
//         int i=0;
//         int j=1;
//         int m=target.length;
//         while(i<m && j<=n){
//             arr.add(var);
//             stack.add(j);
//             if(target[i] != stack.get(i)){
//                 var="Pop";
//                 arr.add(var);
//                 stack.remove(i);
//                 var="Push";
//                 j++;
//             }else{
//                 i++;
//                 j++;
//             }
//         }
//         return arr;
//     }
// }


import java.util.*;

class Solution {
    
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        helper(target, n, 0, 1, ans);
        return ans;
    }

    private void helper(int[] target, int n, int i, int num, List<String> ans) {
        if (i == target.length || num > n) {
            return;
        }

        ans.add("Push");

        if (target[i] == num) {
            helper(target, n, i + 1, num + 1, ans);
        } else {
            ans.add("Pop");
            helper(target, n, i, num + 1, ans);
        }
    }
}