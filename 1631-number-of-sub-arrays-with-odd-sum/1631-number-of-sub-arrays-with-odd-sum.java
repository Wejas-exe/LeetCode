class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int count =0 , oddCount =0 , prefixSum = 0;
        int evenCount =1; // empty prefix sum is even
        for(int num : arr){
            prefixSum+=num;
            if(prefixSum%2 == 0){
                count = (count + oddCount)%MOD;
                evenCount++;
            }else{
                count= (count+ evenCount)%MOD;
                oddCount++;
            }
        }
        return count;
    }
}