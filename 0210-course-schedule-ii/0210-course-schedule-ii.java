class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Edge>[] graph = new ArrayList[numCourses];
        createGraph(graph , numCourses , prerequisites);
        boolean[] visited = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<graph.length;i++){
            if(!visited[i]){
                if(!findOrderUtil(graph , i , visited , stack, st)){
                    return new int[0];
                }
            }
        }
        int[] ans = new int[st.size()];
        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.pop(); 
        }
        return ans ;
    }
    public static boolean findOrderUtil(ArrayList<Edge>[] graph  , int curr , boolean[] visited ,boolean[] stack , Stack<Integer> st){
        visited[curr] = true;
        stack[curr] = true ;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return false ;
            }
            if(!visited[e.dest]){
                if(!findOrderUtil(graph , e.dest , visited, stack , st)){
                    return false ;
                }
            }
        }
        stack[curr] = false ;
        st.push(curr);
        return true ;
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