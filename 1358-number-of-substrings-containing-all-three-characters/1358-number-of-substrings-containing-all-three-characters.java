class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastPos = {-1,-1,-1};
        int count = 0;
        for(int i =0;i<s.length();i++){
            lastPos[s.charAt(i)-'a'] = i;
            count += Math.min(Math.min(lastPos[0],lastPos[1]),lastPos[2])+1;
        }
        return count ;
    }
}