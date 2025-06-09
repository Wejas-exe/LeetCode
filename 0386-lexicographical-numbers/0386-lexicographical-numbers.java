class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =1;i<=9;i++){
            dfs(i , n , list);
        }
        return list ;
    }
    public static void dfs(int curr , int n , ArrayList<Integer> list){
        if(curr > n) return ;

        list.add(curr);

        for(int i =0;i<=9;i++){
            int next = curr*10 + i ;
            if(next > n ) return ;
            dfs(next , n , list) ;
        }
    }
}