class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count[] = new int[3];
        for(int i =0;i<bills.length;i++){
            if(bills[i] == 5){
                count[0] ++;
            }else if(bills[i] == 10){
                if(count[0] == 0) return false;
                count[0]--;
                count[1]++;
            }else{
                if(count[0] == 0) return false;
                if(count[1] > 0){
                    count[1]--;
                    count[0]--;
                }else{
                    if(count[0] < 3) return false;
                    count[0]-=3;
                }
            }
        }
        return true ;
    }
}