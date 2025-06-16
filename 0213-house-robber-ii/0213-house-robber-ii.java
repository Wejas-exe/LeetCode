class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1 ) return nums[0] ;

        return Math.max(robber(nums , 1 , n-1) , robber(nums , 0 , n-2));
    }
    public int robber(int[] nums , int left , int right){
        if(right == left){
            return nums[left];
        }
        int pre = nums[left];
        int prev = Math.max(nums[left] , nums[left+1]);
        for(int i =left+2 ;i<=right;i++){
            int curr = Math.max(pre+nums[i], prev);
            pre = prev ;
            prev = curr;
        }
        return prev;
    }
}