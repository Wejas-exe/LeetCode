class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1 ) return nums[0];
        int pre = 0;
        int prev = nums[0];
        int max = 0;
        for(int i =1;i<nums.length;i++){
            max = Math.max(pre+nums[i],prev);
            pre = prev ;
            prev = max ;
        }
        return max ;
    }
}