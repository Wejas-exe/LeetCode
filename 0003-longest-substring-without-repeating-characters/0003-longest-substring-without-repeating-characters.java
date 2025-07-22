class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int len = 0 ;
        int maxLen = 0 ;
        int i=0;
        int j=0;
        int n = s.length();
        while(i<n){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                len++;
                maxLen = Math.max(len, maxLen);
                i++;
            }else{
                len--;
                set.remove(s.charAt(j));
                j++;
            }
        }
        return maxLen;
    }
}