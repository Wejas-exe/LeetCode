class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        int n = words[words.length-1].length();
        return n;
    }
}