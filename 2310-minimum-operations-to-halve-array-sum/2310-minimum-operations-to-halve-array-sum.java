class Solution {
    public int halveArray(int[] nums) {
        double total = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            total += (double)num;
            pq.add((double)num);
        }
        double half = (total)/2;
        double sum = total;
        int count = 0;
        while(sum > half){
            double curr = pq.poll()/2;
            count ++;
            sum -= curr ;
            pq.add(curr);
            if(sum <= half) return count ;
        }

        return count;
    }
}