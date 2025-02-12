class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;
        for(int num : nums ){
            int digitSum = getDigitSum(num);
            if(map.containsKey(digitSum)){
                maxSum = Math.max(maxSum , map.get(digitSum) + num);
                map.put(digitSum, Math.max(map.get(digitSum), num));
            }else {
                map.put(digitSum, num);
            }
        }
        return maxSum;
    }
    public int getDigitSum(int n){
        int sum = 0;
        while(n>0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}