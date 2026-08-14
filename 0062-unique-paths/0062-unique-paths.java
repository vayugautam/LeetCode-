class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return func(0,0,m,n,dp);
    }
    int func(int i,int j,int m,int n,int[][] dp){
        if(i<0 || i>=m || j<0 || j>=n) return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        
        dp[i][j]=func(i+1,j,m,n,dp)+func(i,j+1,m,n,dp);
        return dp[i][j];
    }
}