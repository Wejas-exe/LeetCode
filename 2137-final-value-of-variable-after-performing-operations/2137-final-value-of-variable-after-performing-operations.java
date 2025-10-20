class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans =0;
        for(String str : operations){
            for(char c : str.toCharArray()){
                if(c == '+'){
                    ans++;
                    break;
                }else if(c== '-'){
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}