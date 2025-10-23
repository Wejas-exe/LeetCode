class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        while (sb.length() > 2) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < sb.length() - 1; i++) {
                int mod = (sb.charAt(i) - '0' + sb.charAt(i + 1) - '0') % 10;
                next.append(mod);
            }
            sb = next;
        }
        
        return sb.charAt(0) == sb.charAt(1);
    }
}
