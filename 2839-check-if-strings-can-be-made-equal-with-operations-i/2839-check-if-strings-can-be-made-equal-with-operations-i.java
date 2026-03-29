class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.charAt(0) == s2.charAt(0)){
            if(s1.charAt(2) != s2.charAt(2)){
                return false;
            }
        }else{
            if(s1.charAt(0) != s2.charAt(2)){
                return false;
            }
            if(s1.charAt(2) != s2.charAt(0)){
                return false;
            }
        }


        if(s1.charAt(1) == s2.charAt(1)){
            if(s1.charAt(3) != s2.charAt(3)){
                return false;
            }
        }else{
            if(s1.charAt(1) != s2.charAt(3)){
                return false;
            }
            if(s1.charAt(3) != s2.charAt(1)){
                return false;
            }
        }

        return true;

    }
}