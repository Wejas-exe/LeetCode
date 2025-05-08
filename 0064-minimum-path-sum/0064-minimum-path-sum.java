class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[] = new int[m];
        dp[0] = grid[0][0];
        for(int j =1;j<m;j++){
            dp[j] = dp[j-1] + grid[0][j];
        }
        for(int i =1;i<n;i++){
            dp[0] = dp[0]+grid[i][0];
            for(int j=1;j<m;j++){
                dp[j] = Math.min(dp[j-1],dp[j])+grid[i][j];
            }
        }
        return dp[m-1];
    }
}