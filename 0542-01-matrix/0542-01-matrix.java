class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        int[][] res = new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(mat[i][j]==0){
                    res[i][j]=0;
                    q.add(new int[]{i,j});
                }else{
                    res[i][j] =-1;
                }
            }
        }

        int height = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int[] currCell = q.poll();
                for(int d=0;d<4;d++){
                    int nx = currCell[0] +dx[d];
                    int ny = currCell[1] +dy[d];
                    if(nx>=0 && nx<m && ny>=0 && ny<n && res[nx][ny]== -1){
                        res[nx][ny] = height;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            height++;
        }
        return res;
    }
}