class Solution {
    public int maximumDifference(int[] nums) {
        int diff = 0 ;
        int prev = nums[0];
        for(int i = 1 ;i<nums.length;i++){
            if(nums[i] > prev){
                diff = Math.max(diff , nums[i] - prev);
            }
            prev = Math.min(prev , nums[i]);
        }
        if(diff == 0) return -1 ;
        return diff ;
    }
}