class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((int a[], int b[]) -> {
            return a[2] - b[2];
        });
        boolean vis[][] = new boolean[n][n];
        pq.add(new int[]{0, 0, grid[0][0]});
        vis[0][0] = true;
        int dir[] = new int[]{0, 1, 0, -1, 0};
        while (pq.size() > 0) {
            int arr[] = pq.poll();
            if (arr[0] ==( n - 1) && arr[1] == (n - 1)) return arr[2];
            for (int k = 0; k < 4; k++) {
                int ni = dir[k] + arr[0], nj = dir[k + 1] + arr[1];
                if (ni >= 0 && nj >= 0 && ni < n && nj < n && vis[ni][nj] == false) {
                    pq.add(new int[]{ni, nj, Math.max(arr[2], grid[ni][nj])});
                    vis[ni][nj] = true;
                }
            }
        }
        return -1;
    }
}