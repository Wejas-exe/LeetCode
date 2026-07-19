class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int['z'+1];
        for(int i =0;i<s.length();i++){
            last[s.charAt(i)] = i;
        }
        boolean[] seen = new boolean['z' +1];
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(seen[ch]==true) continue;
            while(sb.length()!=0 && sb.charAt(sb.length()-1) >ch && last[sb.charAt(sb.length() - 1)] >i){
                seen[sb.charAt(sb.length()-1)] = false;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(ch);
            seen[ch] = true;
        }
        return sb.toString();
    }
}