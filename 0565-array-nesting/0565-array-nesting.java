class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int ans=0;
        for(int k=0;k<n;k++){
            if(visited[k]) continue;
            int current=k;
            int count=0;
            while(!visited[current]){
                visited[current]=true;
                count++;
                current=nums[current];
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}