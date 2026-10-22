class Solution {
    public int maxProfit(int[] pr) {
        int minprice=Integer.MAX_VALUE;
        int maxprofit=0;

        for(int i=0;i<pr.length;i++){
            minprice=Math.min(minprice,pr[i]);
            maxprofit = Math.max(pr[i]-minprice,maxprofit);
        }
        return maxprofit;
    }
}