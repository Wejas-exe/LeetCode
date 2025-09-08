class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for(int i =1;i<n;i++){
            int temp = i;
            boolean valid = true ;
            while(temp > 0){
                if(temp %10 ==0){
                    valid = false;
                    break;
                }
                temp = temp/10;
            }
            if(!valid) continue;
            temp = n-i;
            while(temp > 0){
                if(temp %10 ==0){
                    valid = false;
                    break;
                }
                temp = temp/10;
            }
            if(!valid) continue;
            ans[0] = i;
            ans[1] = n-i;
            return ans;
        }
        return ans;
    }
}