class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i =0;i<n-1;i++){
            if(nums[i] == nums[i+1]){
                nums[i] = 2*nums[i];
                nums[i+1] = 0;
            }
        }
        int[] res = new int[n];
        Arrays.fill(res,0);
        int j =0;
        for(int num : nums){
            if(num != 0){
                res[j++] = num ;
            }
        }
        return res;
    }
}