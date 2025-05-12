class Solution {
    public List<Integer> intersection(int[][] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length ;
        for(int i =0;i<nums[0].length;i++){
            set.add(nums[0][i]);
        }
        for(int i=1;i<n;i++){
            HashSet<Integer> set1 = new HashSet<>();
            for(int j =0;j<nums[i].length ;j++){
                if(set.contains(nums[i][j])){
                    set1.add(nums[i][j]);
                    set.remove(nums[i][j]);
                }
            }
            set.clear();
            set.addAll(set1);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list ;
    }
}