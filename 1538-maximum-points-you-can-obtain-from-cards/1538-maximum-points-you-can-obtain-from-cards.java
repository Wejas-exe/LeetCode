class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int ans = 0;
        int total = Arrays.stream(cardPoints).sum();

        for (int i = 0; i < n - k; i++) {
            ans += cardPoints[i];
        }

        int sum = ans;
        for (int i = 1; i <= k; i++) {
            sum = sum - cardPoints[i - 1] + cardPoints[i + (n - k) - 1];
            ans = Math.min(ans, sum);
        }

        return total - ans;
    }
}
