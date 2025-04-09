class Solution {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        int count2 = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num < k) return -1;
            if(num > k && !set.contains(num)){
                count++;
                set.add(num);
            }
            if(num == k) count2 ++;
            if(count2 == nums.length) return 0;
        }
        if(count == 0) return -1;
        return count ;
    }
}