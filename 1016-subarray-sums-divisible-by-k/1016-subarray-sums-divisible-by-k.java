class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        int n = nums.length;
        int[] count = new int[k];
        count[0] = 1;
        for(int i =0;i<n;i++){
            sum += nums[i];
            int rem = (sum%k);
            if(rem < 0) rem+=k;
            ans += count[rem];
            count[rem]++;
        }
        return ans;
    }
}