class Solution {
    public int numRabbits(int[] answers) {
        int n = answers.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<n;i++){
            map.put(answers[i] , map.getOrDefault(answers[i],0)+1);
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int x = entry.getKey();
            int freq = entry.getValue();
            int groupSize = x+1;
            int groups = (freq + x)/groupSize;
            ans += groups*groupSize;
        }
        return ans;
    }
}