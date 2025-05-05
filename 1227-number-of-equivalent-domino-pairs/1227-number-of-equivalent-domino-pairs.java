class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i =0;i<dominoes.length;i++){
            int a = dominoes[i][0];
            int b = dominoes[i][1];
            String key = Math.min(a, b) + ":" + Math.max(a, b);
            map.put(key,map.getOrDefault(key,0) +1);
        }
        int count = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() == 2) count += 1;
            if(entry.getValue() >=3) {
                count += (entry.getValue()*(entry.getValue()-1))/2;
            }
        }
        return count ;
    }
}