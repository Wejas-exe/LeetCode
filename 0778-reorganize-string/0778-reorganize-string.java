class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        
        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Max heap to store characters based on frequency
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                maxHeap.add(new int[]{i, count[i]});
            }
        }

        // If the most frequent character count is greater than (s.length() + 1) / 2, return ""
        if (maxHeap.peek()[1] > (s.length() + 1) / 2) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        
        // Process the heap to arrange characters optimally
        while (maxHeap.size() > 1) {
            int[] a = maxHeap.poll();
            int[] b = maxHeap.poll();

            sb.append((char)(a[0] + 'a'));
            sb.append((char)(b[0] + 'a'));

            if (a[1] > 1) {
                a[1]--;
                maxHeap.add(a);
            }
            if (b[1] > 1) {
                b[1]--;
                maxHeap.add(b);  // Corrected this line
            }
        }

        // If any single character remains, append it at the end
        if (!maxHeap.isEmpty()) {
            sb.append((char)(maxHeap.poll()[0] + 'a'));
        }

        return sb.toString();
    }
}
