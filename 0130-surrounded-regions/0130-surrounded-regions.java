class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] marked = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(board[i][j] == 'O'){
                        q.add(new int[]{i,j});
                        marked[i][j] = true;
                    }
                }
            }
        }
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for(int[] d: dir){
                int nx = x +d[0];
                int ny = y +d[1];
                if(nx > 0 && nx<m-1 && ny>0 && ny<n-1 && board[nx][ny] == 'O' && !marked[nx][ny]){
                    marked[nx][ny] = true ;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!marked[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}