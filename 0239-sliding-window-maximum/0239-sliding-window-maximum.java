class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length ;
        int[] ans = new int[n-k+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        int max = Integer.MIN_VALUE;
        for(int i =0;i<k ;i++){
            pq.add(new int[]{i,nums[i]});
            max = Math.max(max,nums[i]);
        }
        ans[0] = max ;
        int j = 1;
        for(int i=k;i<n;i++){
            pq.add(new int[]{i,nums[i]});
            while(pq.peek()[0] <= i-k){
                pq.poll();
            }
            ans[j++] = pq.peek()[1];
        }
        return ans;
    }
}