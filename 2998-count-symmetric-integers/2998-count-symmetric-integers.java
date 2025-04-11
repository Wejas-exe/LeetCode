class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;

        for (int i = low; i <= high; i++) {
            int len = countDigits(i);
            if (len % 2 != 0) continue;

            int[] digits = new int[len];
            int temp = i;
            for (int j = len - 1; j >= 0; j--) {
                digits[j] = temp % 10;
                temp /= 10;
            }

            int half = len / 2;
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < half; j++) {
                sum1 += digits[j];
                sum2 += digits[j + half];
            }

            if (sum1 == sum2) ans++;
        }

        return ans;
    }

    public int countDigits(int num) {
        if (num == 0) return 1;
        return (int) Math.log10(num) + 1;
    }
}
