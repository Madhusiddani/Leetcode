class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            Set<Character> vowels = new HashSet<>();
            for (int j = i; j < word.length() && isVowel(word.charAt(j)); j++) {
                vowels.add(word.charAt(j));
                if (vowels.size() == 5) count++;
            }
        }
        return count;
    }

    private static boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) >= 0;
    }
}
  