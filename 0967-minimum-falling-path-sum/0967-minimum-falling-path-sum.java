class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int j =0;j<matrix[0].length;j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i=1 ;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1])+matrix[i][j];
                }else if(j == n-1){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1])+matrix[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1])) +matrix[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE ;
        for(int j =0;j<n;j++){
            min = Math.min(min,dp[m-1][j]);
        }
        return min ;
    }
}