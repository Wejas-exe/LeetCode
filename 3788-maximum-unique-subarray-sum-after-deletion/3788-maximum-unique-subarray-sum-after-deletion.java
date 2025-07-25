class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0 ;
        int max = Integer.MIN_VALUE;
        for(int num:  nums){
            max = Math.max(max,num);
            if(num > 0 && !set.contains(num)){
                sum += num;
                set.add(num);
            }
        }
        if(set.size() == 0 ){
            return max;
        }
        return sum;
    }
}