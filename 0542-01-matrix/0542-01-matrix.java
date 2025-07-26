class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    ans[i][j] = 0;
                    q.add(new int[]{i,j});
                }else{
                    ans[i][j] = -1;
                }
            }
        }
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int x = curr[0];
            int y = curr[1];
            for(int[] d: dir){
                int nx = x+d[0];
                int ny = y+d[1];
                if(nx >= 0 && nx<m && ny>=0 && ny<n && ans[nx][ny] == -1){
                    ans[nx][ny] = ans[x][y] +1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return ans;
    }
}