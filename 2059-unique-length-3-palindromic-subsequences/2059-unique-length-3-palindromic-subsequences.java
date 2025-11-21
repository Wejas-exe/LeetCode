class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        
        for (int i = 0; i < s.length(); i++) { 
            if (first[s.charAt(i) - 'a'] == - 1) {
                first[s.charAt(i) - 'a'] = i;
            }
            last[s.charAt(i) - 'a'] = i;
        }
        
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1 || first[i] == last[i] ) {
                continue;
            }
            
            Set<Character> between = new HashSet();
            for (int j = first[i] + 1; j < last[i]; j++) {
                between.add(s.charAt(j));
            }
            
            ans += between.size();
        }
        
        return ans;
    }
}