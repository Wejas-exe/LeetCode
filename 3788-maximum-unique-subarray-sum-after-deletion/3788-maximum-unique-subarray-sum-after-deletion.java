class Solution {
    public int maxSum(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashSet<Integer> set = new HashSet<>();
        
        for(int num: nums){
            pq.add(num);
        }
        int max = pq.peek();
        while(!pq.isEmpty()){
            if(pq.peek() > 0){
                set.add(pq.peek());
            }
            pq.poll();
        }
        int sum = 0 ;
        for(int n : set){
            sum += n;
        }
        if(set.size() == 0){
            return max;
        }
        return sum;
    }
}