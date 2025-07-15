class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) return false ;
        int vov = 0 ;
        int con = 0 ;
        for(int i =0;i<word.length();i++){
            char c = Character.toLowerCase(word.charAt(i));
            if(c =='#' || c== '$' || c == '@'){
                return false ;
            }
            if(c == 'a' || c=='e' || c=='i' || c=='o' || c=='u'){
                vov++;
            }else{
                boolean number = Character.isDigit(c);
                if(number) continue;
                con++;
            }
        }
        if(vov <1 || con <1) return false ;
        return true ;

    }
}