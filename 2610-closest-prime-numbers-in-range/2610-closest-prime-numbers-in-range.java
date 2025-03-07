class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean isPrime[] = sieve(right);
        int prev = -1 , minDiff = Integer.MAX_VALUE;
        int[] ans ={-1,-1};
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                if (prev != -1 && (i - prev) < minDiff) {
                    minDiff = i - prev;
                    ans[0] = prev;
                    ans[1] = i;
                }
                prev = i;
            }
        }
        return ans;
    }
    private boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}