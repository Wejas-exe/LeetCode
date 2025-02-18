class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        while(i<haystack.length()){
            int temp =i;
            while(j<needle.length() && i<haystack.length() && haystack.charAt(i)==needle.charAt(j)){
                j++;
                i++;
            }
            if(j==needle.length()){
                return i-needle.length();
            }else{
                j=0;
                i = temp+1;
            }
        }
        return -1;
    }
}