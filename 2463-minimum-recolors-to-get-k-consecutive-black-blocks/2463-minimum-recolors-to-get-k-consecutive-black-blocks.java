class Solution {
    public int minimumRecolors(String blocks, int k) {
        int count = 0;
        for(int i =0 ; i<k ; i++){
            if(blocks.charAt(i) == 'B'){
                count++;
            }
        }
        int maxCount = count;
        for(int i = 1; i+k-1<blocks.length() ; i++){
            if(blocks.charAt(i-1) == 'B') count --;
            if(blocks.charAt(i+k-1) == 'B') count ++;
            maxCount = Math.max(maxCount , count );
        }
        return k-maxCount;
    }
}