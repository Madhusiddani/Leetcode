class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < candyType.length; i++) {
            set.add(candyType[i]);
        }

        int maxAllowed = candyType.length / 2;
        int uniqueTypes = set.size();

        return Math.min(uniqueTypes, maxAllowed);
    }
}