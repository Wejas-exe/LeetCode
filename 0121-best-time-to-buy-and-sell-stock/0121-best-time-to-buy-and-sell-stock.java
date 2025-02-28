class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int maxProfit = 0 ;
        for(int i =0;i<prices.length;i++){
            if(prices[i]<=buy){
                buy = prices[i];
            }else{
                int profit = prices[i] - buy;
                maxProfit = Math.max(profit,maxProfit);
            }
        }
        return maxProfit ;
    }
}