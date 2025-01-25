class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i =0; i<n ; i++){
            if(!Objects.equals(map1.get(s.charAt(i)),map2.get(t.charAt(i)))){
                return false;
            }
            map1.put(s.charAt(i),i);
            map2.put(t.charAt(i),i);
        }
        return true;
    }
}