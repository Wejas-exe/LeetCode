class Solution {
    public int findDuplicate(int[] nums) {
        int[] count = new int[nums.length+1];
        for(int num : nums){
            if(count[num]!=0){
                return num;
            }
            count[num]++;
        }
        return -1;
    }
}