class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0 ;
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        while(i<n){
            while(i+1 < n && nums[i]== nums[i+1]){
                i++;
            }
            list.add(nums[i]);
            i++;
        }
        for(int k =0;k<list.size();k++){
            nums[k] = list.get(k);
        }
        return list.size(); 
    }
}