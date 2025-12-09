class Solution {
    static int mod = 1000000007 ;
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int ans = 0 ;
        HashMap<Integer,Integer> left = new HashMap<>();
        HashMap<Integer,Integer> right = new HashMap<>();
        for (int num : nums) {
            right.put(num, right.getOrDefault(num, 0) + 1);
        }
        for(int i =0;i<n;i++){
            int x = nums[i] ;
            right.put(x,right.getOrDefault(x ,0)-1);

            int target = 2*x ;
            int countLeft = left.getOrDefault(target , 0);
            int countRight = right.getOrDefault(target , 0);

            ans = (int)((ans+(1L*countLeft*countRight)%mod)%mod);

            left.put(x, left.getOrDefault(x, 0) + 1);
        }
        return ans ;
    }
}