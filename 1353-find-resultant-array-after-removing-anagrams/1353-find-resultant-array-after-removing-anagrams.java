class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        if (words.length == 1) {
            return new ArrayList<>(List.of(words[0]));
        }
        boolean[] include = new boolean[words.length];
        for(int  i =0;i<words.length-1;i++){
            String s = words[i];
            if(!include[i]){
                list.add(s);
            }
            String t = words[i+1];
            if(isAnagram(s,t)){
                include[i+1] = true;
            }
            if(i+1 == words.length-1){
                if(!isAnagram(words[i] , words[i+1])){
                    list.add(words[i+1]);
                }
            }
        }
        return list;
    }
    public boolean isAnagram(String s , String t){
        if(s.length() != t.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i =0;i<s.length();i++){
            count1[s.charAt(i)-'a']++;
            count2[t.charAt(i)-'a']++;
        }
        for(int i =0;i<26;i++){
            if(count1[i] != count2[i]) return false;
        }
        return true ;
    }
}