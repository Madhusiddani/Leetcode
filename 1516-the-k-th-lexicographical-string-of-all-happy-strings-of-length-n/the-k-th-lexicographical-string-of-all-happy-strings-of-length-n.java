class Solution {

    public String getHappyString(int n, int k) {

        int total = 3 * (1 << (n - 1));
        if (k > total) return "";

        k--;
        StringBuilder res = new StringBuilder();
        char last = '\0';

        for (int pos = 0; pos < n; pos++) {

            int branch = 1 << (n - pos - 1);
            int idx = k / branch;

            int count = 0;
            for (char c : new char[]{'a','b','c'}) {
                if (c != last) {
                    if (count == idx) {
                        res.append(c);
                        last = c;
                        break;
                    }
                    count++;
                }
            }

            k %= branch;
        }

        return res.toString();
    }
}