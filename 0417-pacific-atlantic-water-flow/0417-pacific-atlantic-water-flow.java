class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boolean[][] visited = new boolean[m][n];
                boolean pacific = helper(heights, i, j, visited, true);
                visited = new boolean[m][n];
                boolean atlantic = helper(heights, i, j, visited, false);
                if(pacific && atlantic){
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }
    private static boolean helper(int[][] grid, int row, int col, boolean[][] visited, boolean isPacific){
        int m = grid.length, n = grid[0].length;
        boolean pacificBound = (row == 0 || col == 0);
        boolean atlanticBound = (row == m - 1 || col == n - 1);

        if(visited[row][col]) return false;
        visited[row][col] = true;

        if(isPacific && pacificBound){
            return true;
        }
        if(!isPacific && atlanticBound){
            return true;
        }

        boolean right = false;
        boolean left = false;
        boolean down = false;
        boolean up = false;

        if(col + 1 < n && grid[row][col] >= grid[row][col + 1]){
            right = helper(grid, row, col + 1, visited, isPacific);
        }
        if(col - 1 >= 0 && grid[row][col] >= grid[row][col - 1]){
            left = helper(grid, row, col - 1, visited, isPacific);
        }
        if(row + 1 < m && grid[row][col] >= grid[row + 1][col]){
            down = helper(grid, row + 1, col, visited, isPacific);
        }
        if(row - 1 >= 0 && grid[row][col] >= grid[row - 1][col]){
            up = helper(grid, row - 1, col, visited, isPacific);
        }
        return (up || left || down || right);
    }
}