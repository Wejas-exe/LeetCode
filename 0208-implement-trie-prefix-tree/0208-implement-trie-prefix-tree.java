class Trie {
    Trie children[] ;
    boolean eow = false;
    public Trie() {
        children = new Trie[26];
        for(int i =0;i<26;i++){
            children[i] = null;
        }
    }
    //public static Trie root = new Trie();
    public void insert(String word) {
        Trie curr = this ;
        for(int i =0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Trie();
            }
            curr = curr.children[idx];
        }
        curr.eow = true ;
    }
    
    public boolean search(String word) {
        Trie curr = this ;
        for(int i =0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }
    
    public boolean startsWith(String prefix) {
        Trie curr = this ;
        for(int i =0;i<prefix.length();i++){
            int idx = prefix.charAt(i) - 'a';

            if(curr.children[idx] == null) return false;

            curr = curr.children[idx];
        }
        return true ;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */