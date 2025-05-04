class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0 ;
        for(int i =0;i<dominoes.length;i++){
            int a = dominoes[i][0];
            int b = dominoes[i][1];
            for(int j =i+1;j<dominoes.length;j++){
                int c = dominoes[j][0];
                int d = dominoes[j][1];
                if((a==c && b==d) || (a==d && b==c)) count++;
            }
        }
        return count ;
    }
}