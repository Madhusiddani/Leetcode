class Solution {
    public int distributeCandies(int[] candyType) {
        return Math.min(
            new HashSet<Integer>() {{
                for (int c : candyType) add(c);
            }}.size(),
            candyType.length / 2
        );
    }
}