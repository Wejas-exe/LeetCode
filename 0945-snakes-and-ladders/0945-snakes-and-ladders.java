class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] connections = new int[n*n+1];
        Arrays.fill(connections,-1);
        boolean[] visited = new boolean[n*n+1];

        int node = 1;
        boolean flag = true;

        for(int i=n-1;i>=0;i--){
            if(flag){
                for(int j=0;j<n;j++){
                    if(board[i][j]!=-1){
                        connections[node]=board[i][j];
                    }
                    node++;
                }
            }
            else{
                for(int j=n-1;j>=0;j--){
                    if(board[i][j]!=-1){
                        connections[node] = board[i][j];
                    }
                    node++;
                }
            }
            flag = !flag;
        }

        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i=1;i<=n*n-1;i++){
            if(!map.containsKey(i)){
                map.put(i,new ArrayList<>());
            }
            for(int count =1;count<=6;count++){
                int nbr = count+i;
                if(nbr<=n*n){
                if(connections[nbr]!=-1){
                    map.get(i).add(connections[nbr]);
                }
                else{
                    map.get(i).add(nbr);
                }
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;

        int level = 0;

        while(!queue.isEmpty()){
            int sz = queue.size();
            for(int k=0;k<sz;k++){
                int el = queue.poll();
                if(el==n*n){
                    return level;
                }
                for(int nde:map.getOrDefault(el,new ArrayList<>())){
                    if(!visited[nde]){
                        queue.offer(nde);
                        visited[nde]=true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}