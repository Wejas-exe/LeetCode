class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true ;
        for(int i =0;i<n;i++){
            if(!dp[i]) return false ;
            int max = Math.min(i+nums[i] , n-1);
            for(int j = i ;j<= max ;j++){
                dp[j] = true;
            }
        }
        return dp[n-1];
    }
}