class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int len = 0;
        boolean middleUsed = false;
        for (String s : map.keySet()) {
            String rev = "" + s.charAt(1) + s.charAt(0);
            int count = map.get(s);
            if (s.charAt(0) == s.charAt(1)) {
                len += (count / 2) * 4;
                if (count % 2 == 1 && !middleUsed) {
                    len += 2;
                    middleUsed = true;
                }
            } else if (s.compareTo(rev) < 0 && map.containsKey(rev)) {
                int pairCount = Math.min(count, map.get(rev));
                len += pairCount * 4;
            }
        }

        return len;
    }
}
