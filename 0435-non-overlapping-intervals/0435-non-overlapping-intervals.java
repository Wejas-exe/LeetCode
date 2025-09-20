class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int ans = 0 ;
        int curr[] = intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] < curr[1]){
                ans++;
                curr[1] = Math.min(curr[1] , intervals[i][1]); 
            }else{
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
        }
        return ans ;
    }
}