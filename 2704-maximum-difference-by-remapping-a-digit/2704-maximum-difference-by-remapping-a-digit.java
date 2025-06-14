class Solution {
    public int minMaxDifference(int num) {
        String str = String.valueOf(num);
        int startMax = 0 ;
        for(int i =0;i<str.length();i++){
            if(str.charAt(i) != '9'){
                startMax = str.charAt(i) -'0';
                break;
            }
        }
        int startMin = str.charAt(0)-'0';
        int max = findMax(startMax , num ) ;
        int min = findMin(startMin , num ) ;
        return max-min ;
    }
    public int findMax(int start , int num){
        int temp = num ;
        int ans = 0 ;
        int i = 1 ;
        while(temp > 0){
            if(temp%10 == start){
                ans += 9*i;
            }else{
                ans += (temp%10)*i;
            }
            i *= 10;
            temp = temp/10;
        }
        return ans;
    }
    public int findMin(int start , int num){
        int temp = num ;
        int ans = 0 ;
        int i = 1 ;
        while(temp > 0){
            if(temp%10 == start){
                ans += 0*i;
            }else{
                ans += (temp%10)*i;
            }
            i *= 10;
            temp = temp/10;
        }
        return ans;
    }
}