class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int[] res = new int[2];
        Arrays.sort(nums);
        for(int i =0;i<n-1;i++){
            set.add(nums[i]);
            if(nums[i] == nums[i+1]){
                res[0] = nums[i]; 
            }
        }
        set.add(nums[n-1]);
        for(int i =1;i<=n;i++){
            if(!set.contains(i)){
                res[1] = i;
            }
        }
        return res;
    }
}