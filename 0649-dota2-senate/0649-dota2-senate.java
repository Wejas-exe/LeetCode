class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int n = senate.length();
        
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                q1.add(i);
            } else {
                q2.add(i);
            }
        }
        
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int rIndex = q1.poll();
            int dIndex = q2.poll();
            if (rIndex < dIndex) {
                q1.add(rIndex + n);
            } else {
                q2.add(dIndex + n);
            }
        }
        
        return q1.isEmpty() ? "Dire" : "Radiant";
    }
}
