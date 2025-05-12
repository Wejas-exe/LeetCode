class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums1){
            map.put(num , map.getOrDefault(num , 0)+1);
        }
        for(int num : nums2){
            if(map.containsKey(num)){
                list.add(num);
                if(map.get(num) == 1){
                    map.remove(num);
                }else{
                    map.put(num , map.get(num)-1);
                }
            }
        }
        int[] arr = new int[list.size()];
        for(int i =0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}