class Solution {
    public String addBinary(String a, String b) {
        int sum = 0;
        int carry = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;
        
        StringBuilder res = new StringBuilder();
        while(i >= 0 || j >= 0){
            sum = carry;

            if(i >= 0){
                int aLastDigit = a.charAt(i) - '0';
                sum += aLastDigit;
                i--;
            }

            if(j >= 0){
                int bLastDigit = b.charAt(j) - '0';
                sum += bLastDigit;
                j--;
            }

            res.append(sum % 2 == 0 ? '0' : '1');
            carry = sum > 1 ? 1 : 0; 
        }

        if(carry == 1) res.append('1');

        return res.reverse().toString();
    }
}