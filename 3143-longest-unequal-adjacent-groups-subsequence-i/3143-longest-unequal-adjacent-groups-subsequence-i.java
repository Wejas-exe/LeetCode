class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int n = words.length;
        if(n==1){
            List<String> list3 = new ArrayList<>();
            list3.add(words[0]);
            return list3;
        }
        int prev1 = groups[0];
        list1.add(0);
        int prev2 = groups[1];
        list2.add(1);
        for(int i =1;i<n;i++){
            if(groups[i] != prev1){
                list1.add(i);
                prev1 = groups[i];
            }
            if(groups[i] != prev2){
                list2.add(i);
                prev2 = groups[i];
            }
        }
        if(list1.size() > list2.size()){
            return helper(words,list1);
        }else{
            return helper(words,list2);
        }
    }
    public List<String> helper(String[] words  , List<Integer> list){
        List<String> list1 = new ArrayList<>();
        for(int i =0;i<list.size();i++){
            list1.add(words[list.get(i)]);
        }
        return list1;
    }
}