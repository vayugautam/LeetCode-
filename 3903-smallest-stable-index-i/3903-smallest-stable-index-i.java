class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n =nums.length;
        int maxi=nums[0];
        for(int i=0;i<n;i++){
            int mini=Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                mini=Math.min(mini,nums[j]);
            }
            maxi=Math.max(maxi,nums[i]);
            int st=maxi-mini;
            if(st<=k){
                return i;
            }
        }
        return -1;
    }
}