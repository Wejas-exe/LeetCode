class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> b.getValue() - a.getValue());
        for(Map.Entry<Character,Integer> entry : list){
            int temp = entry.getValue();
            while(temp > 0){
                sb.append(entry.getKey());
                temp--;
            }
        }
        return sb.toString();
    }
}