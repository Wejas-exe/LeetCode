class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0 ;
        int j=0;
        int freq = 0 ;
        for(int i =0;i<nums.length;i++){
            sum += nums[i];
            while((long)(i-j+1)*nums[i] - sum > k){
                sum -= nums[j];
                j++;
            }
            freq = Math.max(freq, i-j+1);
        }
        return freq ;
    }
}