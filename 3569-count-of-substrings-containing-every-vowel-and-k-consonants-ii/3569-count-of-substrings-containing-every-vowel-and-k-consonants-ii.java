class Solution {
    public long countOfSubstrings(String word, int k) {
        return validSubstrings(k, word) - validSubstrings(k+1, word);
    }

    private boolean isConsonant(char ch) {
        return ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u';
    }

    private boolean isAllVowelsPresent(int[] freq) {
        return freq['a'-'a']>0 && freq['e'-'a']>0 && freq['i'-'a']>0 && freq['o'-'a']>0 && freq['u'-'a']>0;
    }

    public long validSubstrings(int k, String word) {
        int consCount = 0;
        long count=0;
        int n = word.length();
        int left = 0;
        int[] freq = new int[26];

        for(int right=0; right<n; right++) {
            char ch = word.charAt(right);

            if(isConsonant(ch)) {
                consCount++;
            }
            freq[ch-'a']++;

            while(consCount>=k && isAllVowelsPresent(freq)) {
                count += (n-right);
                char c = word.charAt(left);
                if(isConsonant(c)) {
                    consCount--;
                }
                freq[c-'a']--;
                left++;
            }
        }
        return count;
    }
}