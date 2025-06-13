class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(graph , flights);
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[src] = 0 ;
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src , 0 , 0));
        while(!q.isEmpty()){
            Info curr = q.poll();
            if(curr.stops > k) break ;
            for(int i =0;i<graph[curr.n].size();i++){
                Edge e = graph[curr.n].get(i);
                if(curr.path + e. wt < dist[e.dest]){
                    dist[e.dest] = curr.path + e.wt ;
                    q.add(new Info(e.dest , dist[e.dest] , curr.stops+1));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE){
            return -1 ;
        }else {
            return dist[dst];
        }
    }
    static class Edge{
        int src ;
        int dest ;
        int wt ;
        public Edge(int src , int dest , int wt){
            this.src = src ;
            this.dest = dest ;
            this.wt = wt ;
        }
    }
    static class Info{
        int n ;
        int path ;
        int stops ;
        public Info(int n , int path ,int stops){
            this.n = n;
            this.path = path;
            this.stops = stops ;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph, int[][] flights){
        for(int i =0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int e[] : flights){
            graph[e[0]].add(new Edge(e[0], e[1], e[2]));
        }
    }
}