class Solution {
    public char kthCharacter(int k) {
        if (k == 1) return 'a';
        StringBuilder sb = new StringBuilder("a");
        while (sb.length() < k) {
            int len = sb.length();
            for (int i = 0; i < len; i++) {
                char next = (char)(sb.charAt(i) + 1);
                sb.append(next);
                if (sb.length() == k) {
                    return sb.charAt(k - 1);
                }
            }
        }
        return sb.charAt(k - 1);
    }
}
