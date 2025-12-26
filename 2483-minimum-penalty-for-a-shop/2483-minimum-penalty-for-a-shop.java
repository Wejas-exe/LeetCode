class Solution {
    public int bestClosingTime(String customers) {
        int yes = 0;
        int max = 0;
        int ans =0;
        for(int i =0;i<customers.length();i++){
            char ch = customers.charAt(i);
            if(ch == 'Y'){
                yes++;
            }else{
                yes--;
            } 
            if(yes > max){
                max = yes;
                ans = i+1;
            }
        }
        return ans ;
    }
}