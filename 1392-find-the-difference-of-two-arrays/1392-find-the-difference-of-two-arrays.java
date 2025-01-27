class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }
        for(int num : nums2){
            set2.add(num);
        }
        for(int n : nums2){
            if(set1.contains(n)){
                set1.remove(n);
                set2.remove(n);
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(set1));
        list.add(new ArrayList<>(set2));
        return list;
    }
}