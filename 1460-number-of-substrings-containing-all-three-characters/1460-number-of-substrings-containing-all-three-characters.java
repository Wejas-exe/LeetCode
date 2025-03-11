class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int start =0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()==3){
                count += s.length()-i;
                char c = s.charAt(left);
                map.put(c,map.get(c)-1);
                if(map.get(c)==0){
                    map.remove(c);
                }
                left++;
            }
            
        }
        return count ;
    }
}