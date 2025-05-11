class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = arr[0]%2;
        for(int i =1;i<arr.length;i++){
            if(arr[i]%2 != 0) count++;
            else{
                count = 0;
            }
            if(count == 3) return true ;
        }
        return false ;
    }
}