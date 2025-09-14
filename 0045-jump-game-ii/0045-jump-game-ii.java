class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int jumps = 0 ;
        int reach = 0;
        int maxReach = 0;
        for(int i =0;i<nums.length-1;i++){
            maxReach = Math.max(maxReach, nums[i] + i);
            if(i == reach){
                reach = maxReach;
                jumps++;
            }
        }
        return jumps;
    }
}