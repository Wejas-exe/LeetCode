class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String prev = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int freq = 1;
        for(int i =1;i<prev.length();i++){
            if(prev.charAt(i) == prev.charAt(i-1)){
                freq++;
            }else{
                sb.append(freq).append(prev.charAt(i-1));
                freq = 1;
            }
        }
        sb.append(freq).append(prev.charAt(prev.length()-1));
        return sb.toString();
    }
}