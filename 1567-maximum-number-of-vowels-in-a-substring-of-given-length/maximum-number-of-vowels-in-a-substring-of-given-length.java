class Solution {
    public int maxVowels(String s, int k) {
        int max=0;
        int l=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'|| s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                count++;
            }
            if(i-l+1>k){
                if(s.charAt(l)=='a'||s.charAt(l)=='e'||s.charAt(l)=='i'||s.charAt(l)=='o'||s.charAt(l)=='u'){
                    count--;
                    if(max==k) return max;
                }
                l++;
            }
            max=Math.max(count,max);
        }
        return max;
    }
    
}