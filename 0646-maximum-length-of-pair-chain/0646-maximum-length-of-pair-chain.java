class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b) -> a[1] - b[1]);
        int count = 1;
        int lastPair = pairs[0][1];
        for(int pair[] : pairs){
            if(pair[0] > lastPair){
                count++;
                lastPair = pair[1];
            }
        }
        return count ;
    }
}