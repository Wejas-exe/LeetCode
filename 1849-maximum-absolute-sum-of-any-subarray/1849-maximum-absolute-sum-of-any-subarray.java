class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = 0 ;
        int min = 0 ;
        int sum = 0 ;
        for(int num : nums){
            if(sum < 0 ){
                sum =0;
            }
            sum += num;
            max = Math.max(sum, max);
        }
        sum =0;
        for(int num : nums){
            if(sum>0){
                sum = 0;
            }
            sum+=num;
            min = Math.min(sum , min);
        }
        return Math.max(max,-min);
    }
}