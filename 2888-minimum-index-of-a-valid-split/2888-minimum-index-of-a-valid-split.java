class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int dom = 0;
        int n = nums.size();
        for(int i=0;i<n;i++){
            map.put(nums.get(i) , map.getOrDefault(nums.get(i),0)+1);
            if(map.get(nums.get(i) )> max){
                dom = nums.get(i);
                max = map.get(nums.get(i));
            }
        }
        int count = 0;
        for(int i =0;i<n;i++){
            if(nums.get(i) == dom) count++;
            if(2*count > i+1){
                if(2*(max-count) > n-i-1) return i;
            }
        }
        return -1;
    }
}