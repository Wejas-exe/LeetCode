class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> cm = new HashMap<>();
        HashMap<Integer, Integer> bm = new HashMap<>();

        int n = queries.length;
        int res[] = new int[n];

        for(int i=0; i<n; i++){
            int ball =  queries[i][0];
            int color =  queries[i][1];

            if(bm.containsKey(ball)){
                int oldColor = bm.get(ball);
                cm.put(oldColor, cm.get(oldColor )-1);
                if(cm.get(oldColor) == 0){
                    cm.remove(oldColor);
                }
            }

            bm.put(ball, color);
            cm.put(color, cm.getOrDefault(color, 0)+1);
            res[i] = cm.size();
        }

        return res;
    }
}