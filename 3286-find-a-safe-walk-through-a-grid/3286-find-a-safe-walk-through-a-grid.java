class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        boolean[][] vis = new boolean[m][n];
        return dfs(0,0,health,grid,vis,dp);
    }
    boolean dfs(int i,int j,int health,List<List<Integer>> grid,boolean[][] vis,int[][] dp){
        int m = grid.size();
        int n = grid.get(0).size();
        if(grid.get(i).get(j)==1){
            health--;
        }
        if(health<=0) return false;
        if(i==m-1 && j==n-1) return true;
        // Already visited this cell before with equal or more health
        if(dp[i][j]>=health) return false;
        dp[i][j]=health;
        vis[i][j]=true;
        for(int[] d : dir){
            int ni=i+d[0];
            int nj=j+d[1];
            if(ni>=0 && nj>=0 && ni<m && nj<n && !vis[ni][nj]) {
                if(dfs(ni,nj,health,grid,vis,dp)) return true;
            }
        } 
        vis[i][j]=false;
        return false;
    }
}