class Solution {
    public void duplicateZeros(int[] arr) {
        int zeros = 0;
        int n = arr.length - 1;
        for (int i = 0; i <= n - zeros; i++) {
            if (arr[i] == 0) {
                if (i == n - zeros) {
                    arr[n] = 0;
                    n--;
                    break;
                }
                zeros++;
            }
        }
        int j = n - zeros;
        for (int i = j; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + zeros] = 0;
                zeros--;
                arr[i + zeros] = 0;
            } else {
                arr[i + zeros] = arr[i];
            }
        }
    }
}
