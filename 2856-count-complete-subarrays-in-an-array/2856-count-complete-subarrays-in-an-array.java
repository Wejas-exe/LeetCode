class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int count = 0;
        int i =0;
        int j =0;
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(i<n){
            map.put(nums[i] , map.getOrDefault(nums[i] ,0) +1);
            while(j<nums.length && map.size() == set.size()){
                count += (n-i) ;
                map.put(nums[j] , map.get(nums[j])-1);
                if(map.get(nums[j]) == 0){
                    map.remove(nums[j]);
                }
                j++;
            }
            i++;
        }
        return count;
    }
}