class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,Comparator.comparingDouble(o -> o[1]));
        int count =1;
        int lastPair = pairs[0][1];
        for(int i =0;i<pairs.length-1;i++){
            if(lastPair<pairs[i+1][0]){
                count++;
                lastPair = pairs[i+1][1];
            }
        }
        return count ;
    }
}