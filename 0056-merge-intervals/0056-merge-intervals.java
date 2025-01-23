class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Queue<int[]> q = new LinkedList<>();
        int i =0;
        while(i<intervals.length){
            int temp = intervals[i][0];
            int curr = intervals[i][1];
            while(i+1<intervals.length && curr >= intervals[i+1][0]){
                i++;
                curr = Math.max(curr, intervals[i][1]); 
            }
            q.offer(new int[]{temp, curr}); 
            i++;
        }
        int[][] res = q.toArray(new int[q.size()][]);
        return res;
    }
}