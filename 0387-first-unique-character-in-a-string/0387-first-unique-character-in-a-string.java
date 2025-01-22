class Solution {
    public int firstUniqChar(String s) {
        int[] exists = new int[26];
        for(int i =0;i<s.length();i++){
            exists[s.charAt(i)-'a']++;
        }
        for(int i =0;i<s.length();i++){
            if(exists[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
}