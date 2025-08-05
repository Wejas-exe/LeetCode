class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int count = 0;
        boolean[] contains = new boolean[n];
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if((fruits[i] <= baskets[j]) && !contains[j]){
                    count++;
                    contains[j] = true;
                    break;
                }
            }
        }
        return n- count;
    }
}