class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
       long fixed_bound =0;
       int minK_Idx =-1;
       int maxK_Idx =-1;
       int invalid_Idx =-1;

       for(int i=0;i<nums.length;i++){
        int num = nums[i];

        if(num == minK){ minK_Idx = i;}
        if(num == maxK){ maxK_Idx = i;}
        if(num < minK || num > maxK) { invalid_Idx = i;}

        fixed_bound += Math.max((Math.min(minK_Idx, maxK_Idx) - invalid_Idx), 0);
       } 
       return fixed_bound;
    }
}