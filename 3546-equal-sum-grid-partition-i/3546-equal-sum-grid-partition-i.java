class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        long total = 0;
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                row[i]+=grid[i][j];
                col[j]+=grid[i][j];
                total += grid[i][j];
            }
        }
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += row[i];
            if(2*sum == total) return true ;
        }
        sum = 0;
        for(int i=0;i<m;i++){
            sum += col[i];
            if(2*sum == total) return true ;
        }
        return false;
    }
}