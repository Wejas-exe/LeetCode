class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = Integer.MIN_VALUE ;
        int n = nums.length ;
        for(int i =0;i<n;i++){
            max = Math.max(max , Math.abs(nums[i] - nums[(i+1)%n]));
        }
        return max ;
    }
}