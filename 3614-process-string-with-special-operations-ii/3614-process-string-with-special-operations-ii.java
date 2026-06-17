class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n];

        long currLen = 0;

        // Forward pass: compute lengths
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '*') {
                if (currLen > 0) currLen--;
            } else if (c == '#') {
                currLen = Math.min(currLen * 2, Long.MAX_VALUE);
            } else if (c == '%') {
                // length unchanged
            } else {
                currLen++;
            }

            len[i] = currLen;
        }

        if (k >= currLen) {
            return '.';
        }

        // Backward pass
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            long curr = len[i];
            long prev = (i > 0) ? len[i - 1] : 0;

            if (c == '#') {
                if (prev > 0) {
                    k %= prev;
                }
            } else if (c == '%') {
                k = curr - 1 - k;
            } else if (c == '*') {
                // Length changed from prev -> prev - 1
                // Current string is prefix of previous string,
                // so k remains unchanged.
            } else {
                // Normal character appended at the end
                if (k == prev) {
                    return c;
                }
            }
        }

        return '.';
    }
}