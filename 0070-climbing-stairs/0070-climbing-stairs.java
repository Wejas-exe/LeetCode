class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        return climb(n , dp);
    }
    public int climb(int n , int[] dp){
        if(n==1 || n==2 || n==3){
            return n ;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n-1] = climb(n-1,dp) ;
        dp[n-2] = climb(n-2,dp) ;
        return dp[n-1] +dp[n-2];
    }
}