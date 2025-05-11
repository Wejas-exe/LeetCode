class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i =0;i<s.length();i++){
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        }
        for(Character c : map1.keySet()){
            if (!map1.get(c).equals(map2.get(c))) return false;
        }
        return true ;
    }
}