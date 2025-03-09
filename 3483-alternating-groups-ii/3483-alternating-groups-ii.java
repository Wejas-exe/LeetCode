class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int res = 0;
        int count = 1;
        int lastColor = colors[0];
        for(int i =1;i<n+k-1;i++){
            int index = i%n;
            if(colors[index] == lastColor){
                count = 1;
                lastColor = colors[index];
                continue;
            }
            count++;
            if(count >=k) {
                res++;
            }
            lastColor = colors[index];
        }
        return res;
    }
}