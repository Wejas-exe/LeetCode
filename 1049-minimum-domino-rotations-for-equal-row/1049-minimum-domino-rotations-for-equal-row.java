class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int top = tops[0];
        int bottom = bottoms[0];
        int ans = check(tops ,bottoms , top);
        int res = check(tops , bottoms, bottom);
        if(ans == -1 && res== -1) return -1;
        if(ans == -1 ) return res ;
        if(res == -1 ) return ans ;
        return Math.min(ans , res);
    }
    public int check(int[] tops , int[] bottoms , int top){
        int rotateTop = 0;
        int rotateBottom = 0;
        for(int i =0;i<tops.length;i++){
            if(tops[i]!=top && bottoms[i]!=top){
                return -1 ;
            }
            if(tops[i]!= top) rotateTop++;
            if(bottoms[i] != top) rotateBottom++;
        }
        return Math.min(rotateTop , rotateBottom);
    }
}