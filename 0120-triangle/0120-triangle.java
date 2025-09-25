class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i =1;i<triangle.size();i++){
            for(int j=0 ;j<=i;j++){
                int curr = triangle.get(i).get(j);
                if(j == 0){
                    dp[i][j] = curr + dp[i-1][j];
                }else if(j==i){
                    dp[i][j] = dp[i - 1][j - 1] + curr;
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1] , dp[i-1][j]) + curr;
                }
            }
        }
        int minTotal = dp[n - 1][0];
        for (int j = 1; j < n; j++) {
            minTotal = Math.min(minTotal, dp[n - 1][j]);
        }

        return minTotal;
    }
}