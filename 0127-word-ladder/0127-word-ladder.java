class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0 ;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                String word = q.poll();
                if(word.equals(endWord)) return level;
                for(String neighbour : getNeighbours(word,set)){
                    q.add(neighbour);
                    set.remove(neighbour);
                }
            }
            level++;
        }
        return 0;
    }
    public static List<String> getNeighbours(String word, Set<String> set){
        List<String> list = new ArrayList<>();
        char[] arr = word.toCharArray();
        for(int i =0;i<arr.length;i++){
            char old = arr[i];
            for(char c='a' ;c<='z';c++){
                arr[i] = c;
                String newWord = new String(arr);
                if(set.contains(newWord) && !newWord.equals(word)){
                    list.add(newWord);
                }
            }
            arr[i] = old;
        }
        return list;
    }
}