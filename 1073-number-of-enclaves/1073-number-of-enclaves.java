class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int land = 0 ;
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j== n-1){
                    if(grid[i][j] == 1){
                        //land++;
                        q.add(new int[]{i,j});
                        visited[i][j] = true;
                    }
                }else if(grid[i][j] == 1){
                    land++;
                }
            }
        }
        int occ = 0 ;
        int[][] dir = {{1,0},{0,1},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for(int[] d: dir){
                int nx = x+d[0];
                int ny = y+d[1];
                if(nx >0 && nx<m-1 && ny>0 && ny<n-1 && grid[nx][ny] == 1 && !visited[nx][ny]){
                    occ++;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return land-occ;
    }
}