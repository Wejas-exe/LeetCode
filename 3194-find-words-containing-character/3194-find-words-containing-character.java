class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<words.length;i++){
            for(char c : words[i].toCharArray()){
                if(c==x){
                    set.add(i);
                    continue;
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        return list;
    }
}