class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1;
        int sum = 0 ;
        int ans = 0 ;
        for(int i =0;i<nums.length;i++){
            sum += nums[i];
            int rem = sum%k;
            if(rem < 0) rem += k;
            ans += count[rem];
            count[rem]++;
        }   
        return ans ;    
    }
}