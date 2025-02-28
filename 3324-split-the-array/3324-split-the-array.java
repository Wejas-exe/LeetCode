class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[] count = new int[101];
        int n = nums.length;
        for(int i =0;i<n;i++){
            count[nums[i]]++;
            if(count[nums[i]]>2){
                return false;
            }
        }
        return true;
    }
}