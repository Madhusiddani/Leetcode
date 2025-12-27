public class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int i = 0, j = 0;
        int count = 0;

        while (i < nums1.length && j < nums2.length) {
            int id1 = nums1[i][0];
            int id2 = nums2[j][0];

            if (id1 == id2) {
                count++;
                i++;
                j++;
            } else if (id1 < id2) {
                count++;
                i++;
            } else {
                count++;
                j++;
            }
        }

        count += (nums1.length - i);
        count += (nums2.length - j);

        int[][] result = new int[count][2];

        i = 0; 
        j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {
            int id1 = nums1[i][0];
            int id2 = nums2[j][0];

            if (id1 == id2) {
                result[k][0] = id1;
                result[k][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            } else if (id1 < id2) {
                result[k][0] = id1;
                result[k][1] = nums1[i][1];
                i++;
            } else {
                result[k][0] = id2;
                result[k][1] = nums2[j][1];
                j++;
            }
            k++;
        }
        while (i < nums1.length) {
            result[k][0] = nums1[i][0];
            result[k][1] = nums1[i][1];
            i++;
            k++;
        }

        while (j < nums2.length) {
            result[k][0] = nums2[j][0];
            result[k][1] = nums2[j][1];
            j++;
            k++;
        }

        return result;
    }
}
