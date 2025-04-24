class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int count = 0;
        for(int i =0;i<nums.length;i++){
            HashSet<Integer> set1 = new HashSet<>();
            for(int j=i;j<nums.length;j++){
                set1.add(nums[j]);
                if(set1.size()==set.size()){
                    count += nums.length-j;
                    break;
                }
            }
        }
        return count;
    }
}