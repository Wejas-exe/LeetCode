class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums){
            if(even(num)){
                count++;
            }
        }
        return count ;
    }
    public boolean even(int n){
        int size = 0;
        while(n > 0){
            n = n/10;
            size++;
        }
        return size%2==0;
    }
}