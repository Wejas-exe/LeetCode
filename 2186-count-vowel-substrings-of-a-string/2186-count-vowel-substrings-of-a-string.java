import java.util.HashMap;

class Solution {
    public int countVowelSubstrings(String word) {
        int n = word.length();
        int count = 0;
        int start = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char ch = word.charAt(right);
            
            if (!isVowel(ch)) {
                map.clear();
                start = right + 1;
                left = right + 1;
                continue;
            }
            
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() == 5) {
                char leftChar = word.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            count += left - start;
        }

        return count;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
