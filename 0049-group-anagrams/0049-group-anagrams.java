class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list =  new ArrayList<>();
        int n = strs.length ;
        boolean already[] = new boolean[n];
        for(int i =0;i<n;i++){
            List<String> list1 = new ArrayList<>();
            list1.add(strs[i]);
            if(!already[i]){
                for(int j =i+1;j<n;j++){
                    if(isAnagram(strs[i] ,strs[j])){
                        if(!already[j]){
                            already[j] = true;
                            list1.add(strs[j]);
                        }
                    }
                }
                already[i] = true;
                list.add(list1);
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