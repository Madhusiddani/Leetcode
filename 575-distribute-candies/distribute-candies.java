import java.util.*;

class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> unique = new HashSet<>();

        for (int candy : candyType) {
            unique.add(candy);
        }
        return Math.min(unique.size(), candyType.length / 2);
    }
}