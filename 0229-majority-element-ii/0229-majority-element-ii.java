class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        double val = Math.floor(nums.length/3);
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0)+1);
            if(map.get(num) > val ) {
                if(!list.contains(num)){
                    list.add(num);
                }
            }
        }
        return list ;
    }
}