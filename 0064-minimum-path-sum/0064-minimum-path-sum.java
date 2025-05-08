class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int min[][] = new int[n][m];
        min[0][0] = grid[0][0];
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(j>0 && i==0){
                    min[i][j]= min[i][j-1] +grid[i][j];
                }
                if(i>0 && j==0){
                    min[i][j]= min[i-1][j] +grid[i][j];
                }
                if(i>0 && j>0){
                    min[i][j]=Math.min(min[i-1][j],min[i][j-1]) + grid[i][j];
                }
            }
        }
        return min[n-1][m-1];
    }
}