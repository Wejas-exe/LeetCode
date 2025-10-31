class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans = new int[2];
        int k = 0 ;
        int count[] = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            count[nums[i]]++;
            if(count[nums[i]] > 1){
                ans[k++] = nums[i];
            }
        }
        return ans;
    }
}