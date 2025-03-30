class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for(int i =0;i<s.length();i++){
            last[s.charAt(i)-'a'] = i;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<s.length();i++){
            j = last[s.charAt(i)-'a'];
            while(i < j){
                if(last[s.charAt(i)-'a'] > j){
                    j = last[s.charAt(i)-'a']; 
                }
                i++;
            }
            list.add((j+1)-(sum));
            sum += list.get(list.size()-1);
        }
        return list;
    }
}