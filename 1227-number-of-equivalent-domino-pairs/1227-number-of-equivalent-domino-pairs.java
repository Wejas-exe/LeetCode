class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String,Integer> map = new HashMap<>();
        int count = 0;
        for(int i =0;i<dominoes.length;i++){
            int a = dominoes[i][0];
            int b = dominoes[i][1];
            String key = Math.min(a, b) + ":" + Math.max(a, b);
            map.put(key,map.getOrDefault(key,0) +1);
            count += (map.get(key)-1);
        }
        return count ;
    }
}