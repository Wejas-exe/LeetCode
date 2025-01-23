class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        int freshOrange =0;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }if(grid[i][j]==1){
                    freshOrange++;
                }
            }
        }
        if(freshOrange==0){
            return 0;
        }
        int count =0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                for(int d =0;d<4;d++){
                    int nx = curr[0] +directions[d][0];
                    int ny = curr[1] +directions[d][1];
                    if(nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny]==1){
                        grid[nx][ny] = 2;
                        freshOrange--;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
            count++;
            if(q.isEmpty() && freshOrange==0) return count-1;
        }
        return -1;
    }
}