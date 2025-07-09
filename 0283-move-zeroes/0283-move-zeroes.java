class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0 ;
        int n = nums.length;
        int j = 0 ;
        while(i<n && j<n){
            while(i< n && nums[i] != 0){
                i++;
            }
            while(j<n && nums[j] == 0){
                j++;
            }
            if(i<n && j<n && j>i){
                nums[i] = nums[j];
                nums[j] = 0 ;
                i++;
                j++;
            }else{
                j++;
            }
        }
    }
}