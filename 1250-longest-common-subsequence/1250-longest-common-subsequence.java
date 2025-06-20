class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i =0 ;i<dp.length ;i++){
            for(int j=0 ;j<dp[0].length ;j++){
                dp[i][j] = -1 ;
            }
        }
        return lcs(text1 , text2 , text1.length(), text2.length() , dp);
    }
    public int lcs(String text1 , String text2 , int n , int m , int[][] dp){
        if(n==0 || m == 0 ){
            return 0 ;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(text1.charAt(n-1) == text2.charAt(m-1)){
            return dp[n][m] = 1 + lcs(text1 , text2 , n-1 , m-1  ,dp);
        }else{
            int a = lcs(text1 , text2 , n-1 , m, dp);
            int b = lcs(text1 , text2 , n , m-1 , dp);
            return dp[n][m] = Math.max(a,b);
        }
    }
}