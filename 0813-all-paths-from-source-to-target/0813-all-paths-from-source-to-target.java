class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        dfs(graph , 0 , graph.length-1 , list , list1);
        return list ;
    }
    public void dfs(int[][] graph , int st , int dt ,List<List<Integer>> list,
    List<Integer> list1){
        if(st == dt){
            list.add(new ArrayList<>(list1));
            return ;
        }
        for(int i =0;i<graph[st].length;i++){
            list1.add(graph[st][i]);
            dfs(graph , graph[st][i] , dt , list , list1);
            list1.remove(list1.size()-1);
        }
    }
}