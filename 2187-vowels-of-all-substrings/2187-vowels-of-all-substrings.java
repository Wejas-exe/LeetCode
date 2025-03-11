class Solution {
    public long countVowels(String word) {
        long sum =0;
        for(int i =0;i<word.length();i++){
            char ch = word.charAt(i);
            if(isVowel(ch)){
                sum += (long)(i+1)*(word.length()-i);
            }
        }
        return sum ;
    }
    public boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i'  || c=='o' || c=='u';
    }
}