class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int n = colors.length();
        int i = 0;

        while (i < n) {
            char currColor = colors.charAt(i);
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(neededTime[i]);
            int j = i + 1;

            while (j < n && colors.charAt(j) == currColor) {
                pq.add(neededTime[j]);
                j++;
            }
            while (pq.size() > 1) {
                ans += pq.poll();
            }

            i = j;
        }

        return ans;
    }
}
