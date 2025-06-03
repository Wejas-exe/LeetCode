class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] col = new int[graph.length];
        Arrays.fill(col , -1);
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<graph.length;i++){
            if(col[i] == -1){
                q.add(i);
                col[i] = 0 ;
                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int j =0;j<graph[curr].length;j++){
                        if(col[graph[curr][j]] == col[curr]){
                            return false ;
                        }else if(col[graph[curr][j]] == -1){
                            col[graph[curr][j]] = col[curr] == 0 ? 1 : 0;
                            q.add(graph[curr][j]);
                        }
                    }
                }
            }
        }
        return true ;
    }
}