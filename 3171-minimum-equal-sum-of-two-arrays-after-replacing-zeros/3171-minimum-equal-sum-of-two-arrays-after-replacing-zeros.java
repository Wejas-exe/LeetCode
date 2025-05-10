class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long count1 = 0;
        long sum2 = 0;
        long count2 = 0;
        for(int num : nums1){
            sum1 += num;
            if(num == 0) count1++;
        }
        for(int num : nums2){
            sum2 += num;
            if(num == 0) count2++;
        }
        System.out.println(sum1 + " " + sum2);
        if(sum1 == sum2){
            if(count2 == 0 && count1 == 0) return sum1;
            if(count1 == 0 || count2 == 0) return -1;
            return Math.max(sum1 + count1, sum2 + count2);
        }
        if(sum2 > sum1){
            if(count1 == 0 || (count2 == 0 && count1 + sum1 > sum2)) return -1;
            return Math.max(sum2 + count2, sum1 + count1);
        }
        if(sum1 > sum2){
            if(count2 == 0 || (count1 == 0 && count2 + sum2 > sum1)) return -1;
            return Math.max(sum2 + count2, sum1 + count1);
        }
        return -1;
    }
}
