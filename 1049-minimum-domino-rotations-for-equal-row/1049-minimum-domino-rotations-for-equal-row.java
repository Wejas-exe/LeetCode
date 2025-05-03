class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        int n = tops.length;
        for(int i =0;i<n;i++){
            map.computeIfAbsent(tops[i], k-> new HashSet<>()).add(i);
            map.computeIfAbsent(bottoms[i], k-> new HashSet<>()).add(i);
        }
        int number = -1;
        for(Map.Entry<Integer,HashSet<Integer>> entry : map.entrySet()){
            if(entry.getValue().size() == n){
                number = entry.getKey();
            }
        }
        if(number == -1) return -1;
        int freq = 0;
        int count = 0;
        for(int i =0;i<n;i++){
            if(tops[i]==number){
                freq++;
            }
            if(bottoms[i]==number){
                count++;
            }
        }
        return Math.min(Math.min(freq,n-freq),Math.min(count ,n-count ));
    }
}