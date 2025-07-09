class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> map = new HashSet<>();
        for(int num : nums){
            if(map.contains(num)){
                list.add(num);
            }
            map.add(num);
        }
        return list ;
    }
}