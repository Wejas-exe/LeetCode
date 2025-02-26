class Solution {
    public boolean isBalanced(String num) {
        int evenSum =0;
        int oddSum = 0;
        for(int i =0;i<num.length();i++){
            char ch = num.charAt(i);
            if(i%2==0){
                evenSum += Character.getNumericValue(ch);
            }else{
                oddSum += Character.getNumericValue(ch);
            }
        }
        return oddSum == evenSum;
    }
}