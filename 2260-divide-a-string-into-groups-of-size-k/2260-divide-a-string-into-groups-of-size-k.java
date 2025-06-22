class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        int n = (int)Math.ceil((double)len/k) ;
        String[] arr = new String[n];
        int idx = 0 ;
        for(int i =0 ;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j =0;j<k;j++){
                if(idx < s.length()){
                    sb.append(s.charAt(idx++));
                }else{
                    sb.append(fill);
                }
            }
            arr[i] = sb.toString();
        }
        return arr;
    }
}