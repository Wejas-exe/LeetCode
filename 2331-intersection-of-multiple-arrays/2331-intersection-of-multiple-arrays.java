class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length ;
        for(int i =0;i<n;i++){
            for(int j =0;j<nums[i].length;j++){
                map.put(nums[i][j], map.getOrDefault(nums[i][j],0)+1);
            }
        }
        for(int key : map.keySet()){
            if(map.get(key) == n) list.add(key);
        }
        Collections.sort(list);
        return list ;
    }
}