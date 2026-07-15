class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int j= i+1;
            int st = nums[i];
            int end = nums[i];
            while(j<nums.length && nums[j] == nums[i]+1){
                end = nums[j];
                j++;
                i++;
            }
            if(st==end){
                ans.add(st+"");
            }else{
                ans.add(st+"->"+end);
            }
            i++;
        }
        return ans;
    }
}