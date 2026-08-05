// | Index | Height | LeftMax | RightMax | Water |
// | ----: | -----: | ------: | -------: | ----: |
// |     0 |      0 |       0 |        3 |     0 |
// |     1 |      1 |       1 |        3 |     0 |
// |     2 |      0 |       1 |        3 |     1 |
// |     3 |      2 |       2 |        3 |     0 |
// |     4 |      1 |       2 |        3 |     1 |
// |     5 |      0 |       2 |        3 |     2 |
// |     6 |      1 |       2 |        3 |     1 |
// |     7 |      3 |       3 |        3 |     0 |
// |     8 |      2 |       3 |        2 |     0 |
// |     9 |      1 |       3 |        2 |     1 |
// |    10 |      2 |       3 |        2 |     0 |
// |    11 |      1 |       3 |        1 |     0 |

class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int lm = 0;
        int rm = 0;
        int water = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= lm) {
                    lm = height[l];
                } else {
                    water += lm - height[l];
                }
                l++;
            } else {
                if (height[r] >= rm) {
                    rm = height[r];
                } else {
                    water += rm - height[r];
                }
                r--;
            }
        }
        return water;
    }
}