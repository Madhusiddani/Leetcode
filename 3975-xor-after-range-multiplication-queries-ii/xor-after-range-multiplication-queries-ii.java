class Solution {
    static final int MOD = 1_000_000_007;

    long pow(long b, long e) {
        long r = 1;
        b %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) r = r * b % MOD;
            b = b * b % MOD;
            e >>= 1;
        }
        return r;
    }

    long inv(long x) {
        return pow(x, MOD - 2);
    }

    public int xorAfterQueries(int[] a, int[][] q) {
        int n = a.length, lim = (int) Math.sqrt(n);
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] x : q) {
            int l = x[0], r = x[1], k = x[2], v = x[3];
            if (k >= lim) {
                for (int i = l; i <= r; i += k)
                    a[i] = (int) (1L * a[i] * v % MOD);
            } else {
                map.computeIfAbsent(k, z -> new ArrayList<>()).add(x);
            }
        }

        for (int k : map.keySet()) {
            long[] d = new long[n];
            Arrays.fill(d, 1);

            for (int[] x : map.get(k)) {
                int l = x[0], r = x[1], v = x[3];
                d[l] = d[l] * v % MOD;

                int nxt = l + ((r - l) / k + 1) * k;
                if (nxt < n)
                    d[nxt] = d[nxt] * inv(v) % MOD;
            }

            for (int i = 0; i < n; i++) {
                if (i >= k) d[i] = d[i] * d[i - k] % MOD;
                a[i] = (int) (1L * a[i] * d[i] % MOD);
            }
        }

        int ans = 0;
        for (int x : a) ans ^= x;
        return ans;
    }
}