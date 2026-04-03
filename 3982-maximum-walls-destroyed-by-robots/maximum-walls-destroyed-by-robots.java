class Solution {

    private long[][] arr;
    private int[][] dp;
    private int[] walls;
    private int n;

    public int maxWalls(int[] pos, int[] dist, int[] w) {

        n = pos.length;
        if (n == 0) return 0;

        walls = w;
        Arrays.sort(walls);

        long[][] a = new long[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = pos[i];
            a[i][1] = dist[i];
        }

        Arrays.sort(a, (x, y) -> Long.compare(x[0], y[0]));

        arr = new long[n][4];

        for (int i = 0; i < n; i++) {

            long p = a[i][0];
            long d = a[i][1];

            long left = (i > 0 ? a[i - 1][0] : Long.MIN_VALUE);
            long right = (i < n - 1 ? a[i + 1][0] : Long.MAX_VALUE);

            arr[i][0] = Math.max(p - d, left);
            arr[i][1] = p;
            arr[i][2] = p;
            arr[i][3] = Math.min(p + d, right);
        }

        dp = new int[n][3];
        for (int[] x : dp) Arrays.fill(x, -1);

        return f(0, 2);
    }

    private int f(int i, int prev) {

        if (i == n) return 0;

        if (dp[i][prev] != -1) return dp[i][prev];

        long last = Long.MIN_VALUE;

        if (prev == 0) last = arr[i - 1][1];
        else if (prev == 1) last = arr[i - 1][3];

        int res = 0;

        // left
        long l = arr[i][0], r = arr[i][1];
        int c1 = cnt(Math.max(l, last + 1), r);
        res = Math.max(res, c1 + f(i + 1, 0));

        // right
        l = arr[i][2];
        r = arr[i][3];
        int c2 = cnt(Math.max(l, last + 1), r);
        res = Math.max(res, c2 + f(i + 1, 1));

        return dp[i][prev] = res;
    }

    private int cnt(long l, long r) {

        if (l > r) return 0;

        int i1 = lb(walls, l);
        int i2 = ub(walls, r);

        return i2 - i1;
    }

    private int lb(int[] a, long t) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (a[m] >= t) r = m;
            else l = m + 1;
        }
        return l;
    }

    private int ub(int[] a, long t) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (a[m] > t) r = m;
            else l = m + 1;
        }
        return l;
    }
}