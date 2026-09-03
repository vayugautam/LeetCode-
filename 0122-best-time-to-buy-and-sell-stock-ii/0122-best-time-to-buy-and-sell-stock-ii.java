class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
        int[][] dp = new int[n][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return gain(prices, n, 0, k,dp);
    }
    static int gain(int[] prices, int n, int i, int k,int[][] dp) {
        if (i == n) return 0;
        if (dp[i][k] != -1) return dp[i][k];
        if (k == 2) { // buy
            int c1 = gain(prices,n,i+1,k-1,dp) - prices[i];
            int c2 = gain(prices,n,i+1,k,dp);
            dp[i][k]=Math.max(c1,c2);
        } else { // sell
            int c1 = gain(prices,n,i+1,k+1,dp) + prices[i];
            int c2 = gain(prices,n,i+1,k,dp);
            dp[i][k]=Math.max(c1,c2);
        }
        return dp[i][k];
    }
}