class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<words.length;i++){
            if(containsChar(words[i],x)){
                list.add(i);
            }
        }
        return list;
    }
    public boolean containsChar(String word , char x){
        for(int i =0;i<word.length();i++){
            if(word.charAt(i) == x) return true ;
        }
        return false;
    }
}