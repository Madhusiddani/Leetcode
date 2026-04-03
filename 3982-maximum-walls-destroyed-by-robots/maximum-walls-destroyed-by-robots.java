import java.util.*;

class Solution {

    static final int INF = Integer.MAX_VALUE;
    static final int NEG_INF = Integer.MIN_VALUE;

    static class Node {
        int p, d;
        Node(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;

        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(robots[i], distance[i]);
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a.p));
        Arrays.sort(walls);

        return solve(arr, n, walls);
    }

    private int solve(Node[] arr, int n, int[] walls) {
        int[] dpL = new int[n];
        int[] dpR = new int[n];

        int[] left = buildLeft(arr, n, walls);
        int[] right = buildRight(arr, n, walls);
        int[] common = buildCommon(arr, n, walls);

        dpL[0] = left[0];
        dpR[0] = right[0];

        for (int i = 1; i < n; i++) {
            dpL[i] = left[i] + Math.max(dpL[i - 1], dpR[i - 1] - common[i]);
            dpR[i] = right[i] + Math.max(dpL[i - 1], dpR[i - 1]);
        }

        return Math.max(dpL[n - 1], dpR[n - 1]);
    }

    private int[] buildLeft(Node[] arr, int n, int[] walls) {
        int[] res = new int[n];
        int l = 0, r = -1, m = walls.length;

        for (int i = 0; i < n; i++) {
            int prev = (i == 0) ? NEG_INF : arr[i - 1].p;
            int s = Math.max(prev + 1, arr[i].p - arr[i].d);
            int e = arr[i].p;

            while (r + 1 < m && walls[r + 1] <= e) r++;
            while (l < m && walls[l] < s) l++;

            if (l <= r) res[i] = r - l + 1;
        }
        return res;
    }

    private int[] buildRight(Node[] arr, int n, int[] walls) {
        int[] res = new int[n];
        int l = 0, r = -1, m = walls.length;

        for (int i = 0; i < n; i++) {
            int next = (i == n - 1) ? INF : arr[i + 1].p;
            int s = arr[i].p;
            int e = Math.min(next - 1, arr[i].p + arr[i].d);

            while (r + 1 < m && walls[r + 1] <= e) r++;
            while (l < m && walls[l] < s) l++;

            if (l <= r) res[i] = r - l + 1;
        }
        return res;
    }

    private int[] buildCommon(Node[] arr, int n, int[] walls) {
        int[] res = new int[n];
        int l = 0, r = -1, m = walls.length;

        for (int i = 1; i < n; i++) {
            int s = Math.max(arr[i - 1].p + 1, arr[i].p - arr[i].d);
            int e = Math.min(arr[i].p - 1, arr[i - 1].p + arr[i - 1].d);

            if (s > e) continue;

            while (r + 1 < m && walls[r + 1] <= e) r++;
            while (l < m && walls[l] < s) l++;

            if (l <= r) res[i] = r - l + 1;
        }
        return res;
    }
}