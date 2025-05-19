class Solution {
    public String triangleType(int[] nums) {
        int count = 1;
        Arrays.sort(nums);
        if(nums[0]+nums[1] <= nums[2]) return "none";
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                count++;
            }
        }
        if(count == 3){
            return "equilateral";
        }else if(count == 2){
            return "isosceles";
        }else{
            return "scalene";
        }
    }
}