class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];  // 0 = unvisited, 1 = visiting, 2 = safe
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, color)) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    private boolean dfs(int[][] graph, int node, int[] color) {
        if (color[node] > 0) {
            return color[node] == 2;
        }
        
        color[node] = 1;  // Mark node as visiting
        
        for (int neighbor : graph[node]) {
            if (color[neighbor] == 2) {
                continue;  // Already safe node
            }
            if (color[neighbor] == 1 || !dfs(graph, neighbor, color)) {
                return false;  // Cycle detected or leads to unsafe node
            }
        }
        
        color[node] = 2;  // Mark node as safe
        return true;
    }
}
