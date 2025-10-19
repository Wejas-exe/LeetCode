class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb1 = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isAlphabetic(c) || Character.isDigit(c)){
                if(Character.isUpperCase(c)){
                    sb1.append(Character.toLowerCase(c));
                }else{
                    sb1.append(c);
                }
            }
        }
        int i=0;
        int j= sb1.length()-1;
        while(i < j){
            if(sb1.charAt(i) != sb1.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}