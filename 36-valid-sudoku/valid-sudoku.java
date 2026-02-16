import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashMap<String, HashSet<Character>> hm = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char num = board[i][j];

                if (num == '.')
                    continue;

                String rowKey = "row" + i;
                String colKey = "col" + j;
                String boxKey = "box" + (i / 3) + (j / 3);

                hm.putIfAbsent(rowKey, new HashSet<>());
                hm.putIfAbsent(colKey, new HashSet<>());
                hm.putIfAbsent(boxKey, new HashSet<>());

                if (hm.get(rowKey).contains(num) ||
                    hm.get(colKey).contains(num) ||
                    hm.get(boxKey).contains(num)) {
                    return false;
                }

                hm.get(rowKey).add(num);
                hm.get(colKey).add(num);
                hm.get(boxKey).add(num);
            }
        }

        return true;
    }
}
