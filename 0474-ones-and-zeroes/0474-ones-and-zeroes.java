class Solution {
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[strs.length][m+1][n+1];
        for(int[][] rows : dp){
            for(int[] row: rows){
                Arrays.fill(row,-1);
            }
        }
        return findMax(strs, m, n, 0);     
    }

    public int findMax(String[] strs, int m, int n, int idx){
        if(idx == strs.length)return 0;

        if(m == 0 && n == 0){
            return 0;
        }

        if(dp[idx][m][n] != -1)return dp[idx][m][n];
        int zero = 0;
        int one = 0;
        for(int i = 0; i< strs[idx].length(); i++){
            if(strs[idx].charAt(i) == '0'){
                zero++;
            }else one++;
        }

        int pick = Integer.MIN_VALUE;
        if(m >= zero && n >= one){
            pick = 1 + findMax(strs, m-zero, n-one, idx+1);
        }
 
        int notPick = findMax(strs, m, n, idx+1);

        return dp[idx][m][n] = Math.max(pick, notPick);
    }
}