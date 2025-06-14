class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int og = image[sr][sc];
        if (og == color) return image;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr ,sc});
        image[sr][sc] = color;
         while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int d=0;d<4;d++){
                int nx = curr[0] + dir[d][0];
                int ny = curr[1] + dir[d][1];
                if(nx >=0 && nx < m && ny>=0 && ny<n && image[nx][ny] == og){
                    image[nx][ny] = color;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return image;
    }
}