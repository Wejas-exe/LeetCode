class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long ans = 0;
        int prefixCount = 0;
        Map<Integer, Long> map = new HashMap<>();
        
        map.put(0, 1L);
        
        for (int num : nums) {
            if (num % modulo == k) {
                prefixCount++;
            }

            int currRem = prefixCount % modulo;
            
            int targetRem = (currRem - k + modulo) % modulo;
            
            ans += map.getOrDefault(targetRem, 0L);
            
            map.put(currRem, map.getOrDefault(currRem, 0L) + 1);
        }
        
        return ans;
    }
}
