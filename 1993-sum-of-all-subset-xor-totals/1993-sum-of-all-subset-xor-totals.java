class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums , 0 , 0);
    }
    public int helper(int[] nums , int index , int currentXor){
        if(index == nums.length){
            return currentXor;
        }
        int with = helper(nums , index +1 , currentXor ^ nums[index]);        
        int without = helper(nums , index +1 , currentXor);        
        return with +without;
    }
}