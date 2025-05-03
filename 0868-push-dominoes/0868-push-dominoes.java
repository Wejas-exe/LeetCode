class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] sides = new int[n];
        int side = 0;
        for(int i =0;i<n;i++){
            if(dominoes.charAt(i)=='R'){
                side = n;
            }else if(dominoes.charAt(i)=='L'){
                side = 0;
            }else{
                side = Math.max(side-1,0);
            }
            sides[i] += side;
        }
        side = 0;
        for(int i =n-1;i>=0;i--){
            if(dominoes.charAt(i)=='L'){
                side = n;
            }else if(dominoes.charAt(i)=='R'){
                side = 0;
            }else{
                side = Math.max(side-1,0);
            }
            sides[i] -= side;
        }
        StringBuilder sb = new StringBuilder();
        for(int s : sides){
            if(s >0){
                sb.append('R');
            }else if (s <0){
                sb.append('L');
            }else{
                sb.append('.');
            }
            
        }
        return sb.toString();
    }
}