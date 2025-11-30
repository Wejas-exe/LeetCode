class Solution {
    public int minSubarray(int[] nums, int p) {
        int total = 0;
        for(int num : nums){
            total = (total+num) %p;
        }
        int rem = total % p;
        if(rem == 0) return 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int min = nums.length;
        for(int i =0;i<nums.length;i++){
            sum = (sum + nums[i]) %p;
            int needed = (sum - rem +p)%p;
            if(map.containsKey(needed)){
                min = Math.min(min , i- map.get(needed));
            }
            map.put(sum , i);
        }
        if(min == nums.length) return -1;
        return min;
    }
}