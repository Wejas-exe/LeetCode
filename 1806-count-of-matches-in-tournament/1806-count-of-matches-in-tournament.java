class Solution {
    public int numberOfMatches(int n) {
        if(n==1 ) return 0;
        int count = 0;
        while(n > 1){
            if(n%2 ==0){
                count += (n/2);
            }else{
                count += (n/2) +1 ;
            }
            n = (int)Math.ceil(n/2);
        }
        return count ;
    }
}