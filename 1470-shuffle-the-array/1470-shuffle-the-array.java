class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int k =0;
        for(int i =0;i<nums.length;i++){
            ans[k++] = nums[i];
            ans[k++] = nums[i+n];
            if(k==nums.length) return ans;
        }
        return ans;
    }
}