class Solution {
    public String largestGoodInteger(String num) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i=1;i<num.length();i++){
            if(num.charAt(i) == num.charAt(i-1)){
                count++;
                if(count == 3){
                    if(sb.length() != 0){
                        if(num.substring(i-2,i+1).charAt(0) > sb.toString().charAt(0)){
                            sb = new StringBuilder(num.substring(i-2,i+1));
                        }
                    }else{
                        sb = new StringBuilder(num.substring(i-2,i+1));
                    }
                }
            }else{
                count = 1;
            }
        }
        return sb.toString();
    }
}