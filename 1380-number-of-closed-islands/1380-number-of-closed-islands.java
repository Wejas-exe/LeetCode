class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int count = 0 ;
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    if(dfs(i , j , grid , visited)){
                        count ++;
                    }
                }
            }
        }
        return count ;
    }
    public static boolean dfs(int i , int j , int[][] grid,boolean[][] visited){
        if(i < 0 || i>= grid.length || j<0 || j >= grid[0].length){
            return false ;
        }
        if(grid[i][j] == 1 || visited[i][j]) return true ; 
        visited[i][j]= true;
        boolean left = dfs(i,j-1,grid , visited);
        boolean right = dfs(i,j+1,grid,visited);
        boolean up = dfs(i-1,j,grid,visited);
        boolean down = dfs(i+1,j,grid,visited);
        if(left && right && up && down){
            return true ;
        }
        return false ;
    }
}