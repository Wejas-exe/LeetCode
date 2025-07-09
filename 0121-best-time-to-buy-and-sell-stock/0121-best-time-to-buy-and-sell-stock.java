class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==1) return 0;
        int[] leftmin = new int[n];
        leftmin[0] = prices[0];
        int rightmax = prices[n-1];
        for(int i =1;i<n;i++){
            leftmin[i]= Math.min(prices[i],leftmin[i-1]);
        }
        int max = Integer.MIN_VALUE;
        for(int i =n-2;i>=0;i--){
            rightmax= Math.max(prices[i],rightmax);
            max = Math.max(max , rightmax - leftmin[i]);
        }
        return max;
    }
}