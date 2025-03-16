class Solution {
    public long repairCars(int[] ranks, int cars) {
        long max = 0;
        for(int num : ranks){
            max = Math.max(max,num);
        }
        long right = max*cars*cars;
        long left = 1;
        while(left <right){
            long mid = left +(right-left)/2;
            if(canRepair(ranks,mid,cars)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    public boolean canRepair(int[] ranks,long mid,int cars){
        int count = 0;
        for(int i =0;i<ranks.length;i++){
            count += Math.floor(Math.sqrt(mid/ranks[i]));
        }
        return count >= cars;
    }
}