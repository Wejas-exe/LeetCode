class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        int n = s.length();
        for(int i=0;i<=n-10;i++){
            if(set.contains(s.substring(i,i+10))){
                if(!list.contains(s.substring(i,i+10))){
                    list.add(s.substring(i,i+10));
                }
            }else{
                set.add(s.substring(i,i+10));
            }
        }
        return list ;
    }
}