class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> mapp = new HashMap<>();
        for(int i=0;i<=nums.length-k;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i;j<k+i;j++){
                set.add(nums[j]);
            }
            for(int x : set){
                mapp.put(x,mapp.getOrDefault(x,0)+1);
            }
        }
        int ans=-1;
        for(int x:mapp.keySet()){
            if(mapp.get(x)==1){
                ans=Math.max(ans,x);
            }
        }
        return ans;
    }
}