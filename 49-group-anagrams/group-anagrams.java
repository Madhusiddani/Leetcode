class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String, List<String>> hm = new HashMap<>();
      for(String str : strs){
        char[] c = str.toCharArray();
        Arrays.sort(c);
        String key = new String(c);
        if(!hm.containsKey(key)){
            hm.put(key, new ArrayList<>());
        }
        hm.get(key).add(str);
      }  
      return new ArrayList<>(hm.values());
    }
}