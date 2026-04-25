import java.util.*;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        long[] perimeterPos = new long[points.length];
        long sideLen = (long) side;

        // Convert (x, y) → position on perimeter
        for (int i = 0; i < points.length; i++) {
            long x = points[i][0];
            long y = points[i][1];

            if (x == 0) perimeterPos[i] = y;
            else if (y == sideLen) 
                perimeterPos[i] = sideLen + x;
            else if (x == sideLen) 
                perimeterPos[i] = 3 * sideLen - y;
            else 
                perimeterPos[i] = 4 * sideLen - x;
        }

        Arrays.sort(perimeterPos);

        int low = 1;
        int high = (int) ((4 * sideLen) / k) + 1;

        while (low + 1 < high) {
            int midDist = low + (high - low) / 2;
            if (canPlace(midDist, perimeterPos, sideLen, k)) {
                low = midDist;
            } else {
                high = midDist;
            }
        }

        return low;
    }

    private boolean canPlace(int minDist, long[] perimeterPos, long sideLen, int k) {
        int n = perimeterPos.length;
        int[] selectedIdx = new int[k];
        long totalPerimeter = 4 * sideLen;

        // Try starting from index 0
        selectedIdx[0] = 0;
        long lastPicked = perimeterPos[0];

        for (int i = 1; i < k; i++) {
            int nextIndex = Arrays.binarySearch(perimeterPos, lastPicked + minDist);
            if (nextIndex < 0) nextIndex = -(nextIndex + 1);

            if (nextIndex == n) return false;

            selectedIdx[i] = nextIndex;
            lastPicked = perimeterPos[nextIndex];
        }

        if (perimeterPos[selectedIdx[k - 1]] - perimeterPos[0] <= totalPerimeter - minDist) {
            return true;
        }

        // Try shifting starting point
        for (selectedIdx[0] = 1; selectedIdx[0] < selectedIdx[1]; selectedIdx[0]++) {
            for (int j = 1; j < k; j++) {
                while (selectedIdx[j] < n && 
                       perimeterPos[selectedIdx[j]] < perimeterPos[selectedIdx[j - 1]] + minDist) {
                    selectedIdx[j]++;
                }

                if (selectedIdx[j] == n) return false;
            }

            if (perimeterPos[selectedIdx[k - 1]] - perimeterPos[selectedIdx[0]] <= totalPerimeter - minDist) {
                return true;
            }
        }

        return false;
    }
}