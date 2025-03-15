class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = 0;
        for(int num : candies){
            max = Math.max(max,num);
        }
        int left = 0;
        int  right  = max;
        while(left<right){
            int mid = (left+right+1)/2;
            if(canAllocate(candies , k ,mid)){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
    public boolean canAllocate(int[] candies , long k , int mid){
        long num = 0;
        for(int i =0;i<candies.length;i++){
            num += candies[i]/mid;
        }
        return num>=k;
    }
}