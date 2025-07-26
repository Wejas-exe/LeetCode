class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i =0;i<m;i++){
            dfs(grid,i,n-1,m,n);
            dfs(grid,i,0,m,n);
        }
        for(int i=0;i<n;i++){
            dfs(grid, 0,i,m,n);
            dfs(grid, m-1,i,m,n);
        }
        int res = 0 ;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) res++;
            }
        }
        return res;

    }
    public static void dfs(int[][] grid, int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]!=1){
            return ;
        }

        grid[i][j] = 2;

        dfs(grid,i+1,j,m,n);
        dfs(grid,i,j+1,m,n);
        dfs(grid,i-1,j,m,n);
        dfs(grid,i,j-1,m,n);
    }
}