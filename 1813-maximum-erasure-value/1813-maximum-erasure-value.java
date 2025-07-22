class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int i = 0 ;
        int j = 0;
        int n = nums.length;
        int maxSum = 0 ;
        int sum = 0 ;
        while(i<n){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                sum += nums[i];
                i++;
                maxSum = Math.max(sum, maxSum);
            }else{
                sum -= nums[j];
                set.remove(nums[j]);
                j++;
            }
        }
        return maxSum;
    }
}