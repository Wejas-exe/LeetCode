class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i =1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1 ;
                }else{
                    int a = dp[i-1][j] ;
                    int b = dp[i][j-1] ;
                    dp[i][j] = Math.max(a,b);
                }
            }
        }
        return dp[m][n];
    }
}