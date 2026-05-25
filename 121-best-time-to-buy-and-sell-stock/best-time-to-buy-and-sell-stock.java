class Solution {
    public int maxProfit(int[] prices) {
      int maxProfit=0;
      int bestBuy=prices[0];

    for(int i=0;i<prices.length;i++){
   
            bestBuy = Math.min(bestBuy,prices[i]);
            maxProfit=Math.max(maxProfit,prices[i]-bestBuy);   
  
        
    }

    return maxProfit;

    }
};