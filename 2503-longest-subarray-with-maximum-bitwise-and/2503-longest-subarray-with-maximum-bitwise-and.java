class Solution {
    public int longestSubarray(int[] nums) {
        int len = 0;
        int maxAnd = 0 ;
        for(int num: nums){
            maxAnd = Math.max(maxAnd, num);
        }
        int maxCount = 0 ;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == maxAnd){
                count++;
                maxCount = Math.max(count, maxCount);
            }else{
                count = 0;
            }
        }
        return maxCount ;
    }
}