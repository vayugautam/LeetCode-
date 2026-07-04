class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] road : roads){
            int u=road[0];
            int v = road[1];
            int w = road[2];
            graph[u].add(new int[]{v,w});
            graph[v].add(new int[]{u,w});
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n+1];

        q.offer(1);
        vis[1]=true;
        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int[] nei : graph[node]){
                int next = nei[0];
                int dist = nei[1];
                ans=Math.min(ans,dist);
                if(!vis[next]){
                    vis[next]=true;
                    q.offer(next);
                }
            }
        }
        return ans;
    }
}