class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] col = new int[n];
        Arrays.fill(col,-1);
        for(int i =0;i<n;i++){
            if(col[i] == -1){
                if(!dfs(graph,i,col,0)){
                    return false ;
                }
            }
        }
        return true;
    }
    public boolean dfs(int[][] graph,int i, int[] col,int color){
        col[i] = color;
        for(int j =0;j<graph[i].length;j++){
            int dest = graph[i][j];
            if(col[dest] == col[i]){
                return false;
            }else if(col[dest] == -1){
                if(!dfs(graph,dest,col,1-color)){
                    return false;
                }
            }
        }
        return true;
    }
}
