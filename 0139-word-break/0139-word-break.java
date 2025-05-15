class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s,wordDict,new HashMap<>());
    }
    public boolean helper(String s , List<String> wordDict,HashMap<String,Boolean> map){
        if(s.length() == 0) return true ;
        if(map.containsKey(s)) return map.get(s);
        for(int i =1;i<=s.length();i++){
            if(wordDict.contains(s.substring(0,i))){
                if(helper(s.substring(i),wordDict,map)){
                    map.put(s,true);
                    return true ;
                }
            }
        }
        map.put(s,false);
        return false ;
    }
}