class Solution {
    public String[] findWords(String[] words) {
        int[] map = new int[26];

        for (char c : "qwertyuiop".toCharArray()) map[c - 'a'] = 1;
        for (char c : "asdfghjkl".toCharArray()) map[c - 'a'] = 2;
        for (char c : "zxcvbnm".toCharArray()) map[c - 'a'] = 3;

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            int row = map[lower.charAt(0) - 'a'];

            boolean valid = true;

            for (char c : lower.toCharArray()) {
                if (map[c - 'a'] != row) {
                    valid = false;
                    break;
                }
            }

            if (valid) result.add(word);
        }

        return result.toArray(new String[0]);
    }
}