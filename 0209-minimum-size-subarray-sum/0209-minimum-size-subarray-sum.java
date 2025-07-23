class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0 ;
        int j = 0 ;
        int len = 0 ;
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i] >= target) return 1;
            sum += nums[i];
            while(sum >= target){
                sum -= nums[j];
                len = i-j+1;
                System.out.println(len);
                minLen = Math.min(len, minLen);
                j++;
            }
        }
        if(minLen == Integer.MAX_VALUE) return 0 ;
        return minLen;
    }
}