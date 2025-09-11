class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i =0;i<s.length();i++){
            if(s.charAt(i)== 'a'||s.charAt(i)== 'e'||s.charAt(i)== 'i'|| s.charAt(i)== 'o'
            || s.charAt(i)== 'u'|| s.charAt(i)== 'A'||s.charAt(i)== 'E'||s.charAt(i)== 'I'
            || s.charAt(i)== 'O'|| s.charAt(i)== 'U'){
                sb.append(1);
                list.add(s.charAt(i));
            }else{
                sb.append(s.charAt(i));
            }
        }
        int k = 0 ;
        Collections.sort(list);
        for(int i =0;i<s.length();i++){
            if(sb.charAt(i)=='1'){
                sb.setCharAt(i,list.get(k++));
            }
        }
        return sb.toString();
    }
}