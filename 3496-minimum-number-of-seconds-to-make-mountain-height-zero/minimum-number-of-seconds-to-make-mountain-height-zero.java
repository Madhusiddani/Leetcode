class Solution {
    public long minNumberOfSeconds(int height, int[] times) {
        long l = 1, num = 10000000000000000L;

        while (l < num) {
            long mid = (l + num) >> 1;
            long total = 0;
            for (int i = 0; i < times.length && total < height; i++)
                total += (long) (Math.sqrt((double) mid / times[i] * 2 + 0.25) - 0.5);
            if (total >= height)
                num = mid;
            else
                l = mid + 1;
        }

        return l;
    }
}