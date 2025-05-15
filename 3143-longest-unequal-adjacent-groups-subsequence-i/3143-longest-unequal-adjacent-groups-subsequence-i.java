class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        if (n == 1) return new ArrayList<>(List.of(words[0]));
        List<String> list1 = helper(words , groups , 0);
        List<String> list2 = helper(words , groups , 1);
        if(list1.size() > list2.size()) return list1;
        return list2;     
    }
    public List<String> helper(String[] words  , int[] groups , int prev){
        List<String> list = new ArrayList<>();
        list.add(words[prev]);
        int compare = groups[prev];        
        for(int i =prev+1;i<words.length;i++){
            if(groups[i] != compare){
                list.add(words[i]);
                compare = groups[i];
            }
        }
        return list;
    }
}