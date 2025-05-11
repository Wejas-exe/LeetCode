class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        double val = Math.floor(nums.length/3);
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0)+1);
            if(map.get(num) > val ) {
                set.add(num);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        return list ;
    }
}