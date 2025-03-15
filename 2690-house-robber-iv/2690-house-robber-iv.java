class Solution {
    public int minCapability(int[] nums, int k) {
        int left =Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for(int num : nums){
            left= Math.min(left,num);
            right= Math.max(right,num);
        }
        while(left<right){
            int mid = (left+right)/2;
            if(canSelect(nums,k,mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    private boolean canSelect(int[] nums , int k , int mid){
        int i =0;
        int count =0;
        while(i<nums.length){
            if(nums[i]<=mid){
                i++;
                count++;
            }
            i++;
        }
        return count >=k;
    }
}