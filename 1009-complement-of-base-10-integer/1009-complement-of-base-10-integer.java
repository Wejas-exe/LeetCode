class Solution {
    public int bitwiseComplement(int n) {
        int p =0;
        for(int i=31; i>=0; i--){
            if((n & (1<<i))!=0){
                p = i;
                break;
            }
        }
        for(int i=p; i>=0; i--){
            n = n ^ (1<<i);
        }
        return n;
    }
}