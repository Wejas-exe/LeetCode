class Solution {
    public String frequencySort(String s) {
        char[] res = s.toCharArray();
        Character[] ans = new Character[s.length()];
        for(int i = 0;i<s.length();i++){
            ans[i] = res[i];
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : ans){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Arrays.sort(ans , (a,b) ->{
            if(map.get(a).equals(map.get(b))){
                return Character.compare(b,a);
            }
            return Integer.compare(map.get(b),map.get(a));
        });
        for(int i = 0;i<s.length();i++){
            res[i] = ans[i];
        }
        String str = new String(res);
        return str;
    }
}