class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);

        int pre = 0;
        int prev = nums[0];
        int max1 = 0;
        for(int i =1;i<nums.length-1;i++){
            max1 = Math.max(pre+nums[i],prev);
            pre = prev ;
            prev = max1;
        }
        pre = 0;
        prev = nums[1];
        int max2 = 0;
        for(int i=2;i<nums.length;i++){
            max2= Math.max(pre+nums[i],prev);
            pre = prev;
            prev = max2;
        }
        return Math.max(max1,max2) ;
    }
}