class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Edge>[] graph = new ArrayList[numCourses];
        createGraph(graph , numCourses , prerequisites);
        int[] indeg = new int[numCourses];
        calcIndeg(graph , indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i =0;i<indeg.length;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> st = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            st.add(curr);
            for(int i =0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }

        if (st.size() != numCourses) {
            return new int[0];
        }
        int[] ans = new int[st.size()];
        for(int i= 0;i<st.size();i++){
            ans[i] = st.get(i); 
        }
        return ans ;
    }
    public static void calcIndeg(ArrayList<Edge>[] graph , int[] indeg){
        for(int i =0;i<graph.length;i++){
            for(int j = 0 ;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    static class Edge{
        int src ;
        int dest ;
        public Edge(int s , int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph , int numCourses , int[][] prerequisites){
        for(int i =0;i<numCourses;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] e : prerequisites){
            graph[e[1]].add(new Edge(e[1] , e[0]));
        }
    }
}