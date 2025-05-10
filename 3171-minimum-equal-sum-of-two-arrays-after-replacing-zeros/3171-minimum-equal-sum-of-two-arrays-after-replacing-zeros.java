class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long[] res1 = helper(nums1);
        long[] res2 = helper(nums2);

        long sum1 = res1[0], count1 = res1[1];
        long sum2 = res2[0], count2 = res2[1];

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

    public long[] helper(int[] arr){
        long sum = 0, count = 0;
        for(int num : arr){
            sum += num;
            if(num == 0) count++;
        }
        return new long[]{sum, count};
    }
}
