class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int ans = 0 ;
        for(int i=1;i<n-1;i++){
            if(nums[i] == nums[i-1]) continue;
            int a = 0 ;
            for(int j=i-1;j>=0;j--){
                if(nums[i] != nums[j]){
                    a = nums[j];
                    break;
                }
            }
            int b = 0 ;
            for(int j=i+1;j<n;j++){
                if(nums[i] != nums[j]){
                    b= nums[j];
                    break;
                }
            }
            if(a==0 || b==0) continue;
            if((a>nums[i] && b>nums[i]) || (a<nums[i] && b<nums[i])){
                ans++;
            }
        }
        return ans;
    }
}